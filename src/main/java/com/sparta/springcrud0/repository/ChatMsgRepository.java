package com.sparta.springcrud0.repository;

import com.sparta.springcrud0.entity.ChatMsg;
import com.sparta.springcrud0.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMsgRepository extends JpaRepository<ChatMsg, Long> {
    List<ChatMsg> findAllByChatRoom(ChatRoom chatRoom);
}
