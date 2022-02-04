package com.nexters.duckjiduckji.External;

import com.nexters.duckjiduckji.Dto.Message;
import com.nexters.duckjiduckji.Exception.type.ApiServerException;
import com.nexters.duckjiduckji.ExternalApiResponse.baseResponse.ExternalBaseResponse;
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

    public ExternalBaseResponse callApiServer(String apiServerInfo, HttpMethod httpMethod, Message message, HttpHeaders headers, Class clazz) {

        HttpEntity<Object> entity = new HttpEntity<>(message, headers);
        ResponseEntity<ExternalBaseResponse> apiResponse = restTemplate.exchange(apiServerInfo, httpMethod, entity, clazz);
        log.info(apiResponse.toString());

        HttpStatus statusCode = apiResponse.getStatusCode();
        ExternalBaseResponse responseBody = apiResponse.getBody();
        log.info("api server response : " + responseBody.toString());

        if(statusCode != HttpStatus.OK || !responseBody.isSuccess()) {
            throw new ApiServerException("api server error!");
        }

        return responseBody;
    }
}
