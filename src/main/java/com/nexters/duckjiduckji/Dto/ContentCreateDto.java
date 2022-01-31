package com.nexters.duckjiduckji.Dto;

import com.nexters.duckjiduckji.Const.MsgType;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContentCreateDto implements Message {

    @Builder.Default
    private MsgType msgType = MsgType.CREATE;
    private String contentId;
    private String contentType; // "PORAROID", "POSTIT"
    private ContentInnerData data;
    private String sendTime;
}
