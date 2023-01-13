package com.sparta.springcrud0.chat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    private String roomId; // 방번호
    private String sender; // 메시지 보낸사람
    private String message; // 메시지
}
