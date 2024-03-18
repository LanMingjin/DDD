package com.feiniaojin.ddd.application;

import com.feiniaojin.ddd.application.dto.CpMessage;
import com.feiniaojin.ddd.application.dto.MvpMessage;
import com.feiniaojin.ddd.domain.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PlayerOpeServiceImpl implements PlayerOpeService {

    @Resource
    private PlayerOpeRepository playerOpeRepository;

    @Override
    public void handleCpCount(CpMessage cpMessage) {

        PlayerId playerId = new PlayerId(cpMessage.getPlayerId());

        PlayerId cpPlayerId = new PlayerId(cpMessage.getCpPlayerId());

        PlayOpeDomain playerOpe = playerOpeRepository.load(playerId);

        if (playerOpe == null) {
             playerOpe = PlayerOpeFactory.newInstance(playerId);
        }

        playerOpe.countCpCount(cpPlayerId);

        playerOpeRepository.save(playerOpe);
    }

    @Override
    public void handleMvp(MvpMessage mvpMessage) {
        PlayerId playerId = new PlayerId(mvpMessage.getPlayerId());

        MvpTime mvpTime = new MvpTime(mvpMessage.getMvpTime());

        PlayOpeDomain playOpeDomain = playerOpeRepository.load(playerId);

        //没有就创建并插入
        if (playOpeDomain == null) {
            playOpeDomain = PlayerOpeFactory.newInstance(playerId);
        }

        playOpeDomain.handlerFirstMvpTime(mvpTime);

        playerOpeRepository.save(playOpeDomain);
    }
}
