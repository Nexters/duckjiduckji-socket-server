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
    private Double width;
    private Double height;
    private Double opacity;
    private String rotation;
    private String font;
    private ContentPositionData point;
}
