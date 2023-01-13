package com.sparta.springcrud0.controller;

import com.sparta.springcrud0.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import com.sparta.springcrud0.chat.ChatMessage;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private final ChatService chatService;
    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        System.out.println("메세지맵핑!");
        /*if (ChatMessage.MessageType.ENTER.equals(message.getType()))
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");*/
        chatService.createChatMsg(message.getRoomId(), message.getMessage(), message.getSender());
        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
}
