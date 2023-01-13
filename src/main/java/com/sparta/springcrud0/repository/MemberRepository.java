package com.sparta.springcrud0.repository;

import com.sparta.springcrud0.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByName(String memberName);
    Optional<Member> findByNameAndPw(String memberName, String memberPw);
    //Optional<Member> findAllBychatRoomList();
}
