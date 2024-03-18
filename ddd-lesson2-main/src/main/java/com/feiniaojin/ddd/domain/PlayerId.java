package com.feiniaojin.ddd.domain;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class PlayerId {

    private String playerId;

    public PlayerId(String playerId) {
        if (StringUtils.isBlank(playerId)) {
            throw new IllegalArgumentException();
        }

        this.playerId = playerId;
    }
}
