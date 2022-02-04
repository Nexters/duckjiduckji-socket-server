package com.nexters.duckjiduckji.ExternalApiResponse.response;

import com.nexters.duckjiduckji.ExternalApiResponse.baseResponse.ExternalBaseResponse;
import com.nexters.duckjiduckji.ExternalApiResponse.responseData.InData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class InResponse extends ExternalBaseResponse {
    private InData data;
}
