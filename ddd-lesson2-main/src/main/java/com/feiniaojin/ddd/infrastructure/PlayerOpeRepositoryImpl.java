package com.feiniaojin.ddd.infrastructure;

import com.feiniaojin.ddd.domain.*;
import com.feiniaojin.ddd.infrastructure.data.PlayerOpe;
import com.feiniaojin.ddd.infrastructure.mapper.PlayOpeMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class PlayerOpeRepositoryImpl implements PlayerOpeRepository {

    @Resource
    private PlayOpeMapper playOpeMapper;

    @Override
    public PlayOpeDomain load(PlayerId playerId) {

        PlayerOpe playerOpe = playOpeMapper.getByPlayId(playerId.getPlayerId());

        if (Objects.isNull(playerOpe)) {
            return null;
        }

        PlayOpeDomain playOpeDomain = PlayOpeDomain.builder()
                .playerId(new PlayerId(playerOpe.getPlayerId()))
                .cpCount(new CpCount(playerOpe.getCpCount()))
                .build();

        if (!Objects.isNull(playerOpe.getFirstMvpTime())) {
            playOpeDomain.setFirstMvpTime(new MvpTime(playerOpe.getFirstMvpTime()));
        }

        if (!Objects.isNull(playerOpe.getLastCpPlayerId())) {
            playOpeDomain.setLastCpPlayerId(new PlayerId(playerOpe.getLastCpPlayerId()));
        }

        return playOpeDomain;
    }

    @Override
    public void save(PlayOpeDomain playerOpe) {

        PlayerOpe playerOpe1 = PlayerOpe.builder()
                .playerId(playerOpe.getPlayerId().getPlayerId())
                .lastCpPlayerId(playerOpe.getLastCpPlayerId().getPlayerId())
                .cpCount(playerOpe.getCpCount().getCpCount())
                .firstMvpTime(playerOpe.getFirstMvpTime().getMvpTime())
                .build();

        playOpeMapper.insert(playerOpe1);
    }
}
