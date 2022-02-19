package com.nexters.duckjiduckji.External.ApiResponse.Response;

import com.nexters.duckjiduckji.External.ApiResponse.BaseResponse.ExternalBaseResponse;
import com.nexters.duckjiduckji.External.ApiResponse.Data.ContentCreateResponseData;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ContentCreateResponse extends ExternalBaseResponse {
    private ContentCreateResponseData data;
}
