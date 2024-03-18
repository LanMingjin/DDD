package com.feiniaojin.ddd.gateway;

import com.alibaba.fastjson2.JSON;
import com.feiniaojin.ddd.application.dto.MvpMessage;
import com.feiniaojin.ddd.domain.PlayerOpeService;
import jakarta.annotation.Resource;

public class MvpListener {

    @Resource
    private PlayerOpeService playerOpeService;


    public void messageHandler(String message) {
        MvpMessage mvpMessage = JSON.parseObject(message, MvpMessage.class);
        playerOpeService.handleMvp(mvpMessage);
    }
}
