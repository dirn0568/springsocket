package com.sparta.springcrud0.dto;

import com.sparta.springcrud0.entity.Member;
import lombok.Getter;

@Getter
public class LoginDto {
    Long id;
    String name;
    String pw;
    public LoginDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.pw = member.getPw();
    }
}
