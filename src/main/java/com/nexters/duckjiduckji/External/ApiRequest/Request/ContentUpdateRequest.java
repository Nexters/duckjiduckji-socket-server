package com.nexters.duckjiduckji.External.ApiRequest.Request;

import com.nexters.duckjiduckji.Dto.ContentBackground;
import com.nexters.duckjiduckji.Dto.ContentPositionData;
import com.nexters.duckjiduckji.Dto.ContentUpdateDto;
import com.nexters.duckjiduckji.Dto.Image;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ContentUpdateRequest {
    private String roomId;
    private String contentType;
    private String content;
    private String ownerId;
    private String frameType;
    private String font;
    private String rotation;
    private ContentPositionData point;
    private Double opacity;
    private ContentBackground background;
    private List<Image> images;
    private Double width;
    private Double height;
    private List<String> tags;

    public static ContentUpdateRequest convertDto(ContentUpdateDto contentUpdateDto) {

        return ContentUpdateRequest.builder()
                .roomId(contentUpdateDto.getRoomId())
                .contentType(contentUpdateDto.getContentType())
                .content(contentUpdateDto.getData().getContent())
                .ownerId("testUser")
                .frameType(null)
                .rotation(contentUpdateDto.getData().getRotation())
                .font(contentUpdateDto.getData().getFont())
                .point(contentUpdateDto.getData().getPoint())
                .opacity(contentUpdateDto.getData().getOpacity())
                .background(null)
                .images(contentUpdateDto.getData().getImages())
                .width(contentUpdateDto.getData().getWidth())
                .height(contentUpdateDto.getData().getHeight())
                .tags(null)
                .build();
    }
}
