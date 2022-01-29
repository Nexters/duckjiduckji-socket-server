package com.nexters.duckjiduckji;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        String userId = "xowns12327724";

        //hset roomId userId 1
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        Map<String, Object> onLineUserMap = new HashMap<>();
        onLineUserMap.put(userId, 1);
        hashOperations.putAll(roomId, onLineUserMap);

        //hgetall roomId -> room joinMember 조회
        Map<Object, Object> entries = hashOperations.entries(roomId);
        Set<Object> keySet = entries.keySet();
        for(Object key : keySet) {
            System.out.println(key);
        }
    }

    @Test
    @DisplayName("방 out")
    void outTest( ) {

        String roomId = "abcde";
        String userId = "xowns1234";

        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();

        Object exist = (hashOperations.get(roomId, userId));
        if(exist != null) hashOperations.delete(roomId, userId);

        //hgetall roomId -> room joinMember 조회
        Map<Object, Object> entries = hashOperations.entries(roomId);
        Set<Object> keySet = entries.keySet();
          for (Object key : keySet) {
             System.out.println(key);
        }
    }
}
