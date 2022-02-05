package com.nexters.duckjiduckji.Dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContentInnerData { // default 값 설정
    private List<Image> images;
    private String content;
    private String width;
    private String height;
    private String opacity;
    private String rotation;
    private String font;
    private ContentPositionData point;
}
