package com.sparta.springcrud0.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class MemberChatRooms {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private ChatRoom chatRoom;
    @ManyToOne
    private Member member1;
    @ManyToOne
    private Member member2;

    public MemberChatRooms(ChatRoom chatRoom, Member member1, Member member2) {
        this.chatRoom = chatRoom;
        this.member1 = member1;
        this.member2 = member2;
    }
}
