package com.sparta.springcrud0.dto;

import com.sparta.springcrud0.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponseDto {
    private Long id;
    private String name;
    private String pw;

    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.pw = member.getPw();
    }
}
