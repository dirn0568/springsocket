package com.sparta.springcrud0.dto;

import com.sparta.springcrud0.chat.ChatRoom;
import com.sparta.springcrud0.entity.Member;

public class MemberChatResponseDto {
    private Long id;
    private ChatRoom chatRoom;
    private Member member;

    public MemberChatResponseDto(ChatRoom chatRoom, Member member) {
        this.chatRoom = chatRoom;
        this.member = member;
    }
}
