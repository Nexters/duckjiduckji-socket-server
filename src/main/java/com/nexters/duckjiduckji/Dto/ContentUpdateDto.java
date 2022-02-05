package com.nexters.duckjiduckji.Dto;

import com.nexters.duckjiduckji.Const.MsgType;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContentUpdateDto implements Message {

    private MsgType msgType = MsgType.UPDATE;
    private String roomId;
    private String contentType; // "PORAROID", "POSTIT"
    private String contentId;
    private String userId;
    private ContentInnerData data;
}
