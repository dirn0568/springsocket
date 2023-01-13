package com.sparta.springcrud0.repository;

import com.sparta.springcrud0.entity.Member;
import com.sparta.springcrud0.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRoomRepository2 extends JpaRepository<ChatRoom, Long> {
//    List<ChatRoom> findAllByMember(Member Member);
//    Optional<ChatRoom> findByRoomIdAndMemberNotLike(String roomId, Member member);
//    Optional<ChatRoom> findByRoomIdAndMember(String roomId, Member member);

    Optional<ChatRoom> findByRoomId(String memberName);
    //List<ChatRoom> findAllByMember1OrMember2(Member Member1, Member Member2); // Member1 == Member2
}
