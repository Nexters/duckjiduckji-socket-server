package com.nexters.duckjiduckji.External.ApiResponse.Data;

import com.nexters.duckjiduckji.Dto.ContentBackground;
import com.nexters.duckjiduckji.Dto.ContentPositionData;
import com.nexters.duckjiduckji.Dto.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ContentDragResponseData {
    private String roomId;
    private String id;
    private String contentType;
    private String content;
    private String ownerId;
    private String frameType;
    private String rotation;
    private String font;
    private ContentPositionData point;
    private Double opacity;
    private ContentBackground background;
    private List<Image> images;
    private Double width;
    private Double height;
    private List<String> tags;
    private String createdAt;
    private String edtAt;
}
