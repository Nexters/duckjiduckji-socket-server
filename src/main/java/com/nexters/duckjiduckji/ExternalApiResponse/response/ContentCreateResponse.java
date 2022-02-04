package com.nexters.duckjiduckji.ExternalApiResponse.response;

import com.nexters.duckjiduckji.ExternalApiResponse.baseResponse.ExternalBaseResponse;
import com.nexters.duckjiduckji.ExternalApiResponse.responseData.ContentCreateData;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ContentCreateResponse extends ExternalBaseResponse {
    private ContentCreateData data;
}
