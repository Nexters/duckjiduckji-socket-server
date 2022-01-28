package com.nexters.duckjiduckji.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexters.duckjiduckji.Const.MsgType;
import com.nexters.duckjiduckji.Dto.*;
import com.nexters.duckjiduckji.Service.MessageService;
import com.nexters.duckjiduckji.Util.ApiHelper;
import com.nexters.duckjiduckji.Util.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

// 클라에서 publish로 보내면 얘가 받음 -> publish/room/{roomId}
@Controller
@Slf4j
@RequiredArgsConstructor
public class MessageController {
    private final SimpMessagingTemplate template; //특정 Broker로 메세지를 전달
    private final MessageService messageService;
    private final JsonUtil jsonUtil;

    // 방 in 처리
    @MessageMapping(value = "/room/{roomId}")
    public void roomJoin(@DestinationVariable("roomId") String roomId, Message message) {

        log.info(jsonUtil.printJson(message));
        MsgType msgType = message.getMsgType();
        Message forwardMessage = message;

        //함수명 변경
        if(msgType == MsgType.CREATE) forwardMessage = messageService.createMessage(message, roomId);
        else if(msgType == MsgType.UPDATE) forwardMessage = messageService.updateMessage(message, roomId);
        else if(msgType == MsgType.DELETE) forwardMessage = messageService.deleteMessage(message, roomId);
        else if(msgType == MsgType.JOIN) forwardMessage = messageService.inMessage(message, roomId);
        else if(msgType == MsgType.LEAVE) forwardMessage = messageService.outMessage(message, roomId);

        template.convertAndSend("/subscribe/room/" + roomId, forwardMessage);
    }
}
