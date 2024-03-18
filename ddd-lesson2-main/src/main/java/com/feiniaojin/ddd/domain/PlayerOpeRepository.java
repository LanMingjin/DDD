package com.feiniaojin.ddd.domain;

public interface PlayerOpeRepository {
    
    PlayOpeDomain load(PlayerId playerId);

    void save(PlayOpeDomain playerOpe);
}
