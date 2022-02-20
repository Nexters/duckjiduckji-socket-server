package com.nexters.duckjiduckji.External.ApiRequest.Request;

import com.nexters.duckjiduckji.Dto.ContentBackground;
import com.nexters.duckjiduckji.Dto.ContentDragDto;
import com.nexters.duckjiduckji.Dto.ContentPositionData;
import com.nexters.duckjiduckji.Dto.Image;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ContentDragRequest {
    private String roomId;
    private String contentType;
    private String ownerId;
    private String rotation;
    private ContentPositionData point;

    public static ContentDragRequest convertDto(ContentDragDto contentDragDto) {
        return ContentDragRequest.builder()
                .roomId(contentDragDto.getRoomId())
                .contentType(contentDragDto.getContentType())
                .ownerId(contentDragDto.getUserId())
                .rotation(contentDragDto.getRotation())
                .point(contentDragDto.getPoint())
                .build();
    }
}
