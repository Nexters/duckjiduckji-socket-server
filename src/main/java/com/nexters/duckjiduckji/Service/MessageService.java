package com.nexters.duckjiduckji.Service;


import com.nexters.duckjiduckji.Dto.*;
import com.nexters.duckjiduckji.Util.ApiHelper;
import com.nexters.duckjiduckji.Util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MessageService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ApiHelper apiHelper;
    private final HttpHeaders jsonHeader;
    private final JsonUtil jsonUtil;

    @Value("${api.server.info")
    private String apiServerUrl;

    public MessageService(RedisTemplate redisTemplate, ApiHelper apiHelper, @Qualifier("application-json-header") HttpHeaders jsonHeader, JsonUtil jsonUtil) {
        this.redisTemplate = redisTemplate;
        this.apiHelper = apiHelper;
        this.jsonHeader = jsonHeader;
        this.jsonUtil = jsonUtil;
    }

    // CREATE
    public Message createMessage(Message message, String roomId) {
        //String contentId = callApiServer(apiServerUrl, HttpMethod.POST, message, jsonHeader, message.getClass());
        ((ContentCreateDto) message).setContentId("aaaaaa");
        ((ContentCreateDto) message).setSendTime((apiHelper.getCurrentTime()));
        return message;
    }

    // UPDATE
    public Message updateMessage(Message message, String roomId) {
       //callApiServer(apiServerUrl, HttpMethod.PUT, message, jsonHeader, message.getClass());
        ((ContentUpdateDto) message).setSendTime((apiHelper.getCurrentTime()));
        return message;
    }

    // DELETE
    public Message deleteMessage(Message message, String roomId) {
        //callApiServer(apiServerUrl, HttpMethod.DELETE, message, jsonHeader, message.getClass());
        ((ContentDeleteDto) message).setSendTime((apiHelper.getCurrentTime()));
        return message;
    }

    // IN
    public Message inMessage(Message message, String roomId) {
        //callApiServer(apiServerUrl, HttpMethod.POST, message, jsonHeader, message.getClass());
        //String errorMsg = "api 서버 error msg";
        //if(true) throw new ApiServerException(roomId + ":" + errorMsg);

        String userId = ((InMessage)message).getUserId();
        return inProcess(roomId, userId);
    }

    // OUT
    public Message outMessage(Message message, String roomId) {
        //callApiServer(apiServerUrl, HttpMethod.POST, message, jsonHeader, message.getClass());

        String userId = ((OutMessage)message).getUserId();
        return outProcess(roomId, userId);
    }

    public InMessage inProcess(String roomId, String userId) {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.put(roomId, userId, 1);

        List<String> onLineUsers = new ArrayList(hashOperations.entries(roomId).keySet());

        InMessage inMessage = InMessage.builder()
                .userId(userId)
                .onlineUsers(onLineUsers)
                .build();

        return inMessage;
    }

    public OutMessage outProcess(String roomId, String userId) {

        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.delete(roomId, userId);

        List<String> onLineUsers = new ArrayList(hashOperations.entries(roomId).keySet());

        OutMessage outMessage = OutMessage.builder()
                .userId(userId)
                .onlineUsers(onLineUsers)
                .build();

        return outMessage;
    }
}
