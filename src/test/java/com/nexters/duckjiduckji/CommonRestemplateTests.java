package com.nexters.duckjiduckji;

import com.nexters.duckjiduckji.External.External;
import com.nexters.duckjiduckji.Dto.ContentCreateDto;
import com.nexters.duckjiduckji.ExternalApiResponse.baseResponse.ExternalBaseResponse;
import com.nexters.duckjiduckji.ExternalApiResponse.response.ContentCreateResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CommonRestemplateTests {

    @Autowired
    private External external;

    @Autowired
    @Qualifier("application-json-header")
    private HttpHeaders jsonHeader;

    @Value("${api.server.info}")
    private String serverInfo;

    @Test
    @DisplayName("api 서버 연동 테스트")
    @Disabled
    public void restemplateTest( ) {

        ContentCreateDto contentCreateDto = ContentCreateDto.builder()
                                            .contentId("aaaa")
                                            .contentType("poraroid")
                                            .data(null)
                                            .build();

        ExternalBaseResponse apiResponse = external.callApiServer(serverInfo, HttpMethod.POST, contentCreateDto, jsonHeader, ContentCreateResponse.class);

        boolean statusCode = apiResponse.isSuccess();
        assertTrue(statusCode);
    }
}
