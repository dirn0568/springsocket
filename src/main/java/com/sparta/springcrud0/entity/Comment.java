package com.sparta.springcrud0.entity;

import com.sparta.springcrud0.dto.CommentRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
// @Setter
@RequiredArgsConstructor // 이게 아닌 그냥 빈 생성자 하나 생성해줘도 가능하긴함
//@NoArgsConstructor // 매개변수가 없는 생성자
//@AllArgsConstructor // 필드 전부 생성자로 들어감
public class Comment extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    @JsonIgnore // 이게 뭔지도 모르겠네
    private Board board;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    //public Comment () {}

    public Comment(CommentRequestDto commentRequestDto, Board board, Member member) {
        this.content = commentRequestDto.getContent();
        this.board = board;
        this.member = member;
    }

    public void CommentUpdate(CommentRequestDto commentRequestDto) {
        this.content = commentRequestDto.getContent();
    }
}
