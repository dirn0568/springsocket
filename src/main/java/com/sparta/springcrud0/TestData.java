package com.sparta.springcrud0;

import com.sparta.springcrud0.entity.Member;
import com.sparta.springcrud0.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestData implements ApplicationRunner {

    private final MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        memberRepository.save(new Member("test123", "12345678")); // me
        memberRepository.save(new Member("test456", "12345678"));
        memberRepository.save(new Member("test789", "12345678"));
        memberRepository.save(new Member("test111", "12345678"));
        memberRepository.save(new Member("test222", "12345678"));
    }
}
