package com.nexters.duckjiduckji.ResponseDto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ContentCreateApiResponse extends BaseApiResponse {
    private String contentId;
}
