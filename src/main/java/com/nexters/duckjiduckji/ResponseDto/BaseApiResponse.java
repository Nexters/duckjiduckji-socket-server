package com.nexters.duckjiduckji.ResponseDto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class BaseApiResponse {
    private String code;
    private String msg;
}
