package com.nexters.duckjiduckji.External.ApiRequest.Request;

import com.nexters.duckjiduckji.Dto.ContentBackground;
import com.nexters.duckjiduckji.Dto.ContentCreateDto;
import com.nexters.duckjiduckji.Dto.ContentPositionData;
import com.nexters.duckjiduckji.Dto.Image;
import lombok.*;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ContentCreateRequest {
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

    public static ContentCreateRequest convertDto(ContentCreateDto contentCreateDto) {

        return ContentCreateRequest.builder()
                .roomId(contentCreateDto.getRoomId())
                .contentType(contentCreateDto.getContentType())
                .content(contentCreateDto.getData().getContent())
                .ownerId("testUser")
                .frameType(null)
                .rotation(contentCreateDto.getData().getRotation())
                .font(contentCreateDto.getData().getFont())
                .point(contentCreateDto.getData().getPoint())
                .opacity(contentCreateDto.getData().getOpacity())
                .background(null)
                .images(contentCreateDto.getData().getImages())
                .width(contentCreateDto.getData().getWidth())
                .height(contentCreateDto.getData().getHeight())
                .tags(null)
                .build();
    }
}
