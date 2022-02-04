package com.nexters.duckjiduckji.Dto;

import com.nexters.duckjiduckji.Const.MsgType;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OutMessage implements Message {

    @Builder.Default
    private MsgType msgType = MsgType.LEAVE;
    private String userId;
    private List<String> onlineUsers;
}
