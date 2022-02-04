package com.nexters.duckjiduckji.ExternalApiResponse.response;

import com.nexters.duckjiduckji.ExternalApiResponse.baseResponse.ExternalBaseResponse;
import com.nexters.duckjiduckji.ExternalApiResponse.responseData.OutData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class OutResponse extends ExternalBaseResponse {
    private OutData data;
}
