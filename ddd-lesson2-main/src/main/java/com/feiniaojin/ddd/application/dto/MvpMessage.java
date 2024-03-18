package com.feiniaojin.ddd.application.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MvpMessage {

    private String playerId;

    private Date mvpTime;
}
