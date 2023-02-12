package com.sparta.springcrud0.service;

import com.sparta.springcrud0.entity.*;
import com.sparta.springcrud0.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

// import static java.awt.Color.red; // 이런것도 있네 근데 이거 뭐임??

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRoomRepository2 chatRoomRepository2;
    private final ChatMsgRepository chatMsgRepository;
    private final MemberRepository memberRepository;
    private final MemberChatRoomsRepository memberChatRoomsRepository;



    @Transactional // 이거를 빼면 데이터 생성이 안되나????
    public ChatRoom createChatRoom(Member memberOwner, Member memberParticipant) {
        if (memberChatRoomsRepository.findByMember1AndMember2(memberOwner, memberParticipant).isPresent()
                || memberChatRoomsRepository.findByMember1AndMember2(memberParticipant, memberOwner).isPresent()) {
            throw new IllegalArgumentException("이미 채팅방이 만들어져 있습니다."); // redirect로 채팅방 컨트롤러 연결시키기? 아니면 새로운 컨트롤로 만들어서 redirect로 연결??
        }

        String roomId = UUID.randomUUID().toString();
        ChatRoom chatRoom = new ChatRoom(roomId);
        //ChatRoom chatRoom1 = new ChatRoom(roomId, memberParticipant);
        chatRoomRepository2.save(chatRoom);

        MemberChatRooms memberChatRooms = new MemberChatRooms(chatRoom, memberOwner, memberParticipant);
        memberChatRoomsRepository.save(memberChatRooms);
        return chatRoom;
    }
    @Transactional
    public List<Member> memberRooms(Member member) {
        List<Member> members = new ArrayList<>();
        List<MemberChatRooms> memberChatRooms = memberChatRoomsRepository.findAllByMember1OrMember2(member, member);
        for (MemberChatRooms memberChatRoom : memberChatRooms) {
            if (!member.equals(memberChatRoom.getMember1())) {
                members.add(memberChatRoom.getMember1());
                continue;
            }
            members.add(memberChatRoom.getMember2());
        }
        return members;
        /*List<ChatRoom> chatRooms = memberChatRoomsRepository.findAllByMember(member).stream()
                .map(MemberChatRooms::getChatRoom).collect(Collectors.toList()); // entity이름 복수 없애기
        for (ChatRoom chatRoom : chatRooms) {
            memberChatRoomsRepository.findMembersByChatRoomAndMemberNot(chatRoom, member);
        }
        return memberChatRoomsRepository.findMembersByChatRoomAndMemberNot(chat);*/

    }

    @Transactional // 이거를 빼면 데이터 생성이 안되나????
    public void createChatMsg(String roomId, String chatText, String sender) {
        Optional<Member> memberSender = memberRepository.findByName(sender);
        Optional<ChatRoom> chatRoom = chatRoomRepository2.findByRoomId(roomId);

        ChatMsg chatMsg = new ChatMsg(chatRoom.get(), chatText, memberSender.get());
        chatMsgRepository.save(chatMsg);

    }

    @Transactional
    public List<ChatMsg> memberChatList(String roomId) {
        Optional<ChatRoom> chatRoom = chatRoomRepository2.findByRoomId(roomId);
        List<ChatMsg> chatMsgs = chatMsgRepository.findAllByChatRoom(chatRoom.get());
        for (ChatMsg chatMsg : chatMsgs) {
            System.out.println(chatMsg.getMsg());
        }
        return chatMsgs;
    }
}
