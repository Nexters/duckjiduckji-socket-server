package com.nexters.duckjiduckji.Dto;

import com.nexters.duckjiduckji.Const.MsgType;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContentDragDto implements Message {
    private MsgType msgType = MsgType.DRAG;
    private String roomId;
    private String contentType; // "PORAROID", "POSTIT"
    private String contentId;
    private String userId;
    private ContentPositionData point;
    private String rotation;
}
