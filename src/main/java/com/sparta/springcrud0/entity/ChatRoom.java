package com.sparta.springcrud0.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.springcrud0.dto.BoardRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@RequiredArgsConstructor
public class ChatRoom {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column
    private String roomId;

    public ChatRoom(String roomId) {
        this.roomId = roomId;
    }

}
