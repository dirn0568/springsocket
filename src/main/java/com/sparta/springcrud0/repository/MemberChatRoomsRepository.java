package com.sparta.springcrud0.repository;

import com.sparta.springcrud0.entity.ChatRoom;
import com.sparta.springcrud0.entity.Member;
import com.sparta.springcrud0.entity.MemberChatRooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberChatRoomsRepository extends JpaRepository<MemberChatRooms, Long> {
    Optional<MemberChatRooms> findByMember1AndMember2(Member member1, Member member2);
    List<MemberChatRooms> findAllByMember1OrMember2(Member member1, Member member2);
    /*@Query("SELECT m.member FROM MemberChatRooms m WHERE m.chatRoom = :chatRoom AND m.member <> :member") // <> == !=, as == 변수로 선언
    List<Member> findMembersByChatRoomAndMemberNot(@Param("chatRoom") ChatRoom chatRoom, @Param("member") Member member);*/
    //Optional<MemberChatRooms> findByChatRoomAndMemberNotLike(ChatRoom chatRoom, Member member); // 코드는 한눈에 알아보기 쉽게 이거는 X
}
