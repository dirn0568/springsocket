package com.sparta.springcrud0.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class ChatMsg {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private ChatRoom chatRoom;
    @Column
    private String msg;
    @ManyToOne // ManyToOne인데 리스트를 받을 수 있나 반대로 OneToMany인데 객체값 하나만 받을 수 있나
    private Member member;

    public ChatMsg(ChatRoom chatRoom, String msg, Member member) {
        this.chatRoom = chatRoom;
        this.msg = msg;
        this.member = member;
    }

    //    @ManyToOne
//    private Member sender;
//
//    public ChatMsg(String msg, Member receiver, Member sender) {
//        this.msg = msg;
//        this.receiver = receiver;
//        this.sender = sender;
//    }

}
