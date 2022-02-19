package com.nexters.duckjiduckji.External.ApiResponse.Response;

import com.nexters.duckjiduckji.External.ApiResponse.BaseResponse.ExternalBaseResponse;
import com.nexters.duckjiduckji.External.ApiResponse.Data.ContentUpdateResponseData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ContentUpdateResponse extends ExternalBaseResponse {
    private ContentUpdateResponseData data;
}
