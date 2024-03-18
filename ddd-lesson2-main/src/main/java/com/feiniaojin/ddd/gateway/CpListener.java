package com.feiniaojin.ddd.gateway;

import com.alibaba.fastjson2.JSON;
import com.feiniaojin.ddd.application.dto.CpMessage;
import com.feiniaojin.ddd.domain.PlayerOpeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * CP消息监听器
 */
@Component
public class CpListener {

    @Resource
    private PlayerOpeService playerOpeService;


    public void messageHandler(String message) {
        CpMessage cpMessage = JSON.parseObject(message, CpMessage.class);
        playerOpeService.handleCpCount(cpMessage);
    }

}
