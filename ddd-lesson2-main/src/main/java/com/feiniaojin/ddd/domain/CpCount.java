package com.feiniaojin.ddd.domain;

import lombok.Data;

@Data
public class CpCount {

    private Integer cpCount;

    public CpCount (Integer cpCount) {
        this.cpCount = cpCount;
    }

    public void inc() {

        if (cpCount == null) {
            cpCount = 1;
        } else {
            cpCount += cpCount;
        }
    }
}
