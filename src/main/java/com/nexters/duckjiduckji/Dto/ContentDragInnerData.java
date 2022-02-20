package com.nexters.duckjiduckji.Dto;

import lombok.*;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContentDragInnerData {
    private String rotation;
    private ContentPositionData point;
}
