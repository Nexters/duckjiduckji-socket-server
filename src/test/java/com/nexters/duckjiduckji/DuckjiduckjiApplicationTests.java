package com.nexters.duckjiduckji;

import com.nexters.duckjiduckji.Dto.InMessage;
import com.nexters.duckjiduckji.Dto.OutMessage;
import com.nexters.duckjiduckji.Service.MessageService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@SpringBootTest
class DuckjiduckjiApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private MessageService messageService;

    @Test
    void contextLoads() {

    }

    @Test
    @DisplayName("방 in")
    void inTest( ) {

        String roomId = "abcde";
        String userId = "xowns12";

        InMessage inMessage = InMessage.builder()
                             .userId(userId)
                             .onlineUsers(null)
                             .build();

        System.out.println(messageService.inMessage(inMessage, roomId));
    }

    @Test
    @DisplayName("방 out")
    void outTest( ) {

        String roomId = "abcde";
        String userId = "xowns12";

        OutMessage outMessage = OutMessage.builder()
                .userId(userId)
                .onlineUsers(null)
                .build();


        System.out.println(messageService.outMessage(outMessage, roomId));
    }

}
