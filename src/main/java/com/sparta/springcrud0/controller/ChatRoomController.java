package com.sparta.springcrud0.controller;

//import com.sparta.springcrud0.chat.ChatRoom;
import com.sparta.springcrud0.entity.ChatMsg;
import com.sparta.springcrud0.entity.ChatRoom;
import com.sparta.springcrud0.repository.ChatRoomRepository;

import com.sparta.springcrud0.repository.MemberRepository;
import com.sparta.springcrud0.service.ChatService;
import com.sparta.springcrud0.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.sparta.springcrud0.entity.Member;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {
    private final MemberService memberService;
    private final ChatService chatService;
    private final MemberRepository memberRepository;

    @GetMapping("/room")
    public String rooms(Model model) {
        //
        return "chat/room2";
    }

    @PostMapping("/room")
    @ResponseBody
    public Map createRoom(@RequestParam String name, HttpServletRequest request) {
        Map chatMap = new HashMap<>();
        Member memberOwner = memberService.MemberToken(request);
        Optional<Member> memberParticipant = memberRepository.findByName(name);
        chatMap.put("chatRoom", chatService.createChatRoom(memberOwner, memberParticipant.get()));
        chatMap.put("sender", memberOwner.getName());
        return chatMap;
    }

    @GetMapping("/room/enter/{roomId}")
    public String roomDetail(Model model, @PathVariable String roomId) {
        model.addAttribute("roomId", roomId);
        return "chat/memberChatList";
    }


    @GetMapping("/rooms")
    @ResponseBody   //원래 리턴타입 List<ChatRoom>
    public Map roomList(@RequestParam String roomId, HttpServletRequest request) {
        Map map = new HashMap();
        Member member = memberService.MemberToken(request);

        List<Member> members = chatService.memberRooms(member);
        List<ChatMsg> chatMsgs = chatService.memberChatList(roomId);

        map.put("Members", members);
        map.put("ChatMsgs", chatMsgs);

        return map;
    }

    //    @GetMapping("/rooms")
//    @ResponseBody
//    public List<ChatRoom> room() {
//        return chatRoomRepository.findAllRoom();
//    }

    /*@PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name) {
        return chatRoomRepository.createChatRoom(name);
    }*/

    //    @GetMapping("/room/{roomId}")
//    @ResponseBody
//    public ChatRoom roomInfo(@PathVariable String roomId) {
//        return chatRoomRepository.findRoomById(roomId);
//    }
}