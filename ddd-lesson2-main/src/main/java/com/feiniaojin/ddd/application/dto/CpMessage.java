package com.feiniaojin.ddd.application.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CpMessage {

    private String playerId;

    private String cpPlayerId;

    private Date cpDate;
}
