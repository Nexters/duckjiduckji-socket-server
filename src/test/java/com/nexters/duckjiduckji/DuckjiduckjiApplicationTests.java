package com.nexters.duckjiduckji;

import com.nexters.duckjiduckji.Dto.InMessage;
import com.nexters.duckjiduckji.Dto.OutMessage;
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

    @Test
    void contextLoads() {

    }

    @Test
    @DisplayName("방 in")
    void inTest( ) {

        String roomId = "abcde";
        String userId = "xowns12";

        //hset roomId userId 1
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.put(roomId, userId, 1);

        //hgetall roomId -> room joinMember 조회
        List<String> onLineUsers = new ArrayList(hashOperations.entries(roomId).keySet());

        InMessage inMessage = InMessage.builder()
                                .userId(userId)
                                .onlineUsers(onLineUsers)
                                .build();

        System.out.println(inMessage);
    }

    @Test
    @DisplayName("방 out")
    void outTest( ) {

        String roomId = "abcde";
        String userId = "xowns111";

        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.delete(roomId, userId);

        //hgetall roomId -> room joinMember 조회
        List<String> onLineUsers = new ArrayList(hashOperations.entries(roomId).keySet());

        OutMessage outMessage = OutMessage.builder()
                .userId(userId)
                .onlineUsers(onLineUsers)
                .build();

        System.out.println(outMessage);
    }
}
