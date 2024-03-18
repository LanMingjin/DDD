package com.feiniaojin.ddd.domain;

import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
public class MvpTime {

    private Date mvpTime;

    public MvpTime (Date mvpTime) {

        if (Objects.isNull(mvpTime)) {
            throw new IllegalArgumentException();
        }

        this.mvpTime = mvpTime;
    }

    public boolean before(MvpTime firstMvpTime) {
        return this.getMvpTime().before(firstMvpTime.getMvpTime());
    }
}
