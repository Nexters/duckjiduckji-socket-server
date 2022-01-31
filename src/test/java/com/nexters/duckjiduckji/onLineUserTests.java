package com.nexters.duckjiduckji;

import com.nexters.duckjiduckji.Common.Common;
import com.nexters.duckjiduckji.Dto.ContentCreateDto;
import com.nexters.duckjiduckji.Dto.InMessage;
import com.nexters.duckjiduckji.Dto.OutMessage;
import com.nexters.duckjiduckji.Service.MessageService;
import lombok.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class onLineUserTests {

    @Autowired
    private MessageService messageService;

    @Test
    @DisplayName("방 in")
    void inTest( ) {

        String roomId = "abcde";
        String userId = "xowns12";

        InMessage inMessage = InMessage.builder()
                             .userId(userId)
                             .onlineUsers(null)
                             .build();

        InMessage inRes = (InMessage) messageService.inMessage(inMessage, roomId);
        List<String> onlineUser = inRes.getOnlineUsers();

        boolean flag = false;
        if(onlineUser.contains(userId)) flag = true;

        assertEquals(flag, true);
    }

    @Test
    @DisplayName("방 out")
    void outTest( ) {

        String roomId = "abcde";
        String userId = "xowns12";

        InMessage inMessage = InMessage.builder()
                .userId(userId)
                .onlineUsers(null)
                .build();

        // 방 in
        messageService.inMessage(inMessage, roomId);

        OutMessage outMessage = OutMessage.builder()
                .userId(userId)
                .onlineUsers(null)
                .build();

        OutMessage outRes = (OutMessage) messageService.outMessage(outMessage, roomId);
        List<String> onlineUser = outRes.getOnlineUsers();

        boolean flag = false;
        if(onlineUser.contains(userId)) flag = true;

        assertEquals(flag, false);
    }
}
