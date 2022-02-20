package com.nexters.duckjiduckji.External.ApiResponse.Response;

import com.nexters.duckjiduckji.External.ApiRequest.Request.ContentDragRequest;
import com.nexters.duckjiduckji.External.ApiResponse.BaseResponse.ExternalBaseResponse;
import com.nexters.duckjiduckji.External.ApiResponse.Data.ContentDragResponseData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ContentDragResponse extends ExternalBaseResponse {
    private ContentDragResponseData data;
}
