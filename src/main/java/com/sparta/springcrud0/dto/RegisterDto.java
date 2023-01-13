package com.sparta.springcrud0.dto;

import com.sparta.springcrud0.entity.Member;
import lombok.Getter;


@Getter
public class RegisterDto {
    Long id;
    String name;
    String pw;

    public RegisterDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.pw = member.getPw();
    }
}
