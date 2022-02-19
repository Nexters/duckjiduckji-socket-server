package com.nexters.duckjiduckji.External.ApiResponse.BaseResponse;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ExternalBaseResponse {
    private boolean success;
    private String message;
}
