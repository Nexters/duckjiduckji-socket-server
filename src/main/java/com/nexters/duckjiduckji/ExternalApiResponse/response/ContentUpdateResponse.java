package com.nexters.duckjiduckji.ExternalApiResponse.response;

import com.nexters.duckjiduckji.ExternalApiResponse.baseResponse.ExternalBaseResponse;
import com.nexters.duckjiduckji.ExternalApiResponse.responseData.ContentUpdateData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ContentUpdateResponse extends ExternalBaseResponse {
    private ContentUpdateData data;
}
