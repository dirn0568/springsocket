package com.sparta.springcrud0.repository;


import com.sparta.springcrud0.chat.ChatRoom;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ChatRoomRepository {

    private Map<String, ChatRoom> chatRoomMap;

    @PostConstruct
    private void init() {
        System.out.println("여기서 chatRoomMap을 링크드해쉬맵으로 먼저 선언");
        chatRoomMap = new LinkedHashMap<>();
    }

    public List<ChatRoom> findAllRoom() {
        // 채팅방 생성순서 최근 순으로 반환
        List chatRooms = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(chatRooms);
        return chatRooms;
    }

    public ChatRoom findRoomById(String id) {
        System.out.println(chatRoomMap.get(id) + "챗룸맵 겟 id하면 뭐가 나오지");
        return chatRoomMap.get(id);
    }

    /*public ChatRoom createChatRoom(String name) {
        ChatRoom chatRoom = ChatRoom.create(name);
        chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }*/
}
