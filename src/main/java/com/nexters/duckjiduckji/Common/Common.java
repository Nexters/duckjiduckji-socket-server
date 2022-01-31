package com.nexters.duckjiduckji.Common;

import com.nexters.duckjiduckji.Dto.Message;
import com.nexters.duckjiduckji.Exception.type.ApiServerException;
import com.nexters.duckjiduckji.ResponseDto.BaseApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class Common {

    private final RestTemplate restTemplate;

    public BaseApiResponse callApiServer(String apiServerInfo, HttpMethod httpMethod, Message message, HttpHeaders headers, Class clazz) {

        HttpEntity<Object> entity = new HttpEntity<>(message, headers);
        ResponseEntity<BaseApiResponse> apiResponse = restTemplate.exchange(apiServerInfo, httpMethod, entity, clazz);
        log.info(apiResponse.toString());

        // httpStatus와 api 서버에서 오는 statusCode를 같이 봐야할듯??
        if(apiResponse.getStatusCode() != HttpStatus.OK) {
            throw new ApiServerException("api server error!");
        }

        BaseApiResponse responseBody = apiResponse.getBody();
        log.info("api server response : " + responseBody.toString());

        return responseBody;
    }
}
