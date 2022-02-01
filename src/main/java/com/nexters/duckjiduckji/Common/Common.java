package com.nexters.duckjiduckji.Common;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class Common {

    private final RestTemplate restTemplate;

    public Object callApiServer(String apiServerInfo, HttpMethod httpMethod, Object body, HttpHeaders headers, Class clazz) {

        //apiServerInfo = "http://localhost:8888/test";
        HttpEntity<Object> entity = new HttpEntity<>(body, headers);
        ResponseEntity<Object> apiResponse = restTemplate.exchange(apiServerInfo, httpMethod, entity, clazz);
        System.out.println(apiResponse);

        //String className = clazz.getName().split(".")[4]; // com.nexters.duckjuduckj.Dto.ContentCreateDto

        System.out.println("callApiServer :" + apiResponse.getBody());

        return apiResponse.getBody();
    }
}
