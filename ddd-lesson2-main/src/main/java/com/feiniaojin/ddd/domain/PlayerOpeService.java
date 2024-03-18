package com.feiniaojin.ddd.domain;

import com.feiniaojin.ddd.application.dto.CpMessage;
import com.feiniaojin.ddd.application.dto.MvpMessage;

public interface PlayerOpeService {

    void handleCpCount(CpMessage cpMessage);

    void handleMvp(MvpMessage mvpMessage);
}
