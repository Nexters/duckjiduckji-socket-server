package com.nexters.duckjiduckji.External;

import com.nexters.duckjiduckji.Dto.Message;
import com.nexters.duckjiduckji.Exception.type.ApiServerException;
import com.nexters.duckjiduckji.External.ApiResponse.BaseResponse.ExternalBaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class External {

    private final RestTemplate restTemplate;

    public ExternalBaseResponse callApiServer(String apiServerInfo, HttpMethod httpMethod, Object request, HttpHeaders headers, Class clazz) {

        log.info("apiServerInfo : " + apiServerInfo);
        HttpEntity<Object> entity = new HttpEntity<>(request, headers);
        ResponseEntity apiResponse = restTemplate.exchange(apiServerInfo, httpMethod, entity, clazz);
        log.info("[API REPONSE] : " + apiResponse.toString());

        HttpStatus statusCode = apiResponse.getStatusCode();
        ExternalBaseResponse responseBody = (ExternalBaseResponse) apiResponse.getBody();
        log.info("api server response : " + responseBody.toString());

        if(statusCode != HttpStatus.OK || !responseBody.isSuccess()) {
            throw new ApiServerException("api server error!");
        }

        return responseBody;
    }
}
