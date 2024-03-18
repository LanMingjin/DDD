package com.feiniaojin.ddd.domain;


public class PlayerOpeFactory {

    public static PlayOpeDomain newInstance(PlayerId playerId) {

        return PlayOpeDomain.builder().playerId(playerId).build();

    }
}
