package com.sparta.springcrud0.service;

import com.sparta.springcrud0.Enum.MemberEnum;
import com.sparta.springcrud0.dto.MemberResponseDto;
import com.sparta.springcrud0.dto.ResponseDto;
import com.sparta.springcrud0.entity.Board;
import com.sparta.springcrud0.entity.Member;
import com.sparta.springcrud0.jwt.JwtUtil;
import com.sparta.springcrud0.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil; // 객체를 새로 생성하지않고 이걸 하면 사용이되네 뭐지???

    private final String ADMINTOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";

    @Transactional
    public MemberResponseDto findMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new NullPointerException("회원 상세조회 실패")
        );
        MemberResponseDto memberResponseDto = new MemberResponseDto(member);
        return memberResponseDto;
    }

    @Transactional
    public List<MemberResponseDto> findAllMember() {
        List<Member> members = memberRepository.findAll();
        List<MemberResponseDto> memberResponseDtos = new ArrayList<>();
        for (Member member : members) {
            MemberResponseDto memberResponseDto = new MemberResponseDto(member);
            memberResponseDtos.add(memberResponseDto);
        }
        return memberResponseDtos;
    }



    @Transactional
    // @ExceptionHandler 안쓰는거
    public Map RegisterPost(@Valid Member member) {
        Map registerMessage = new HashMap();
        if (memberRepository.findByName(member.getName()).isPresent()) {
            throw new IllegalArgumentException("이미 사용자가 있습니다.");
        }
        memberRepository.save(member);
        registerMessage.put("msg", "회원가입 성공");
        registerMessage.put("status", 200);
        return registerMessage;
    }


    @Transactional
    public ResponseDto LoginPost(Member member, HttpServletResponse response) {
        //Map loginMessage = new HashMap<Integer, Integer>();
        String jwtUtilToken = "";
        if (memberRepository.findByNameAndPw(member.getName(), member.getPw()).isPresent()) {
            Optional<Member> member1 = memberRepository.findByNameAndPw(member.getName(), member.getPw());
            jwtUtilToken = jwtUtil.createToken(member1.get().getId());
            ResponseDto responseDto = new ResponseDto("200", "로그인 성공", null);
            response.addHeader("Authorization", jwtUtilToken);
            return responseDto;
        }
        ResponseDto responseDto = new ResponseDto("400", "로그인 실패", null);
        return responseDto;
    }

    public Member MemberToken(HttpServletRequest request) {
        System.out.println(request.getHeader("Authorization"));
        String token = JwtUtil.getToken(request);
        Optional<Member> member = memberRepository.findById(Long.parseLong(jwtUtil.getUserInfoFromToken(token).getSubject()));

        return member.get();
    }
}
