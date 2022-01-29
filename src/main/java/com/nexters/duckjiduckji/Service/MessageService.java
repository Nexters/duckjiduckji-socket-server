package com.nexters.duckjiduckji.Service;

import com.nexters.duckjiduckji.Const.MsgType;
import com.nexters.duckjiduckji.Dto.*;
import com.nexters.duckjiduckji.Exception.type.ApiServerException;
import com.nexters.duckjiduckji.Util.ApiHelper;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class MessageService {

    private final RestTemplate restTemplate;
    private final RedisTemplate<String, Object> redisTemplate;
    private final ApiHelper apiHelper;
    private final HttpHeaders jsonHeader;

    @Value("${api.server.info")
    private String apiServerUrl;

    public MessageService(RestTemplate restTemplate, RedisTemplate redisTemplate, ApiHelper apiHelper, @Qualifier("application-json-header") HttpHeaders jsonHeader) {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
        this.apiHelper = apiHelper;
        this.jsonHeader = jsonHeader;
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

        /*
        InMessage inMessage = (InMessage) message;
        String userId = inMessage.getUserId();
        inMessage.setSendTime(apiHelper.getCurrentTime());

        //hset roomId userId 1
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        Map<String, Object> onLineUserMap = new HashMap<>();
        onLineUserMap.put(userId, 1);
        hashOperations.putAll(roomId, onLineUserMap);

        //hgetall roomId -> room joinMember 조회
        hashOperations.getOperations().boundHashOps(roomId);
        */
        return message;
    }

    // OUT
    public Message outMessage(Message message, String roomId) {
        //callApiServer(apiServerUrl, HttpMethod.POST, message, jsonHeader, message.getClass());

        /*
        // redis delete
        OutMessage outMessage = (OutMessage) message;
        String userId = outMessage.getUserId();
        outMessage.setSendTime(apiHelper.getCurrentTime());

        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();

        //hexists roomId userId -> 존재하면 !
        //hdel roomId usetId -> 삭제
        Map<String, Object> onLineUserMap = new HashMap<>();
        onLineUserMap.put(userId, 1);
        hashOperations.delete(roomId, onLineUserMap);

        //hgetall roomId -> room joinMember 조회
        hashOperations.getOperations().boundHashOps(roomId);

         */
        return message;
    }


    public String callApiServer(String apiServerInfo, HttpMethod httpMethod, Object body, HttpHeaders headers, Class clazz) {

        apiServerInfo = "http://localhost:8888/test";
        HttpEntity<Object> entity = new HttpEntity<>(body, headers);
        ResponseEntity apiResponse = null;

        apiResponse = restTemplate.exchange(apiServerInfo, httpMethod, entity, clazz);

        String className = clazz.getName().split(".")[4]; // com.nexters.duckjuduckj.Dto.ContentCreateDto
        log.info(apiResponse.toString());

        // response에서 content id만 파싱해서 응답
        if(className.equals("ContentCreateDto")) return "id";
        else return null;
    }
}
