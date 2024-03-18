package com.feiniaojin.ddd.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayOpeDomain {

    /**
     * 玩家ID
     */
    private PlayerId playerId;

    /**
     * 首次获得MVP时间，默认是9999-12-31 23:59:59
     */
    private MvpTime firstMvpTime;

    /**
     * 累计跟几个妹子组过CP
     */
    private CpCount cpCount;

    /**
     * 上一个CP的玩家ID，相同的话不累加
     */
    private PlayerId lastCpPlayerId;

    public void incCpCount() {

        cpCount.inc();

    }

    public void countCpCount(PlayerId cpPlayerId) {

        if (!cpPlayerId.equals(this.getLastCpPlayerId())) {
            incCpCount();
            this.lastCpPlayerId = cpPlayerId;
        }

    }

    public void handlerFirstMvpTime(MvpTime mvpTime) {

        //判断时间是否在默认时间之前
        if (this.firstMvpTime == null || firstMvpTime.before(mvpTime)) {
            this.firstMvpTime = mvpTime;
        }
    }
}
