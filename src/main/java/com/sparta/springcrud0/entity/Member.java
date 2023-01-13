package com.sparta.springcrud0.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) // auto로 하면 id값이 혼자서 올라가는데 IDENTITY로 바꾸니 id가 제대로 올라감 IDENTITY도 이상한데?
    Long id;
    @Size(min=4,max=10)
    @Pattern(regexp="^[a-z0-9]*$")
    @Column(nullable = false)
    String name;
    @Size(min=8,max=15)
    @Pattern(regexp="^[a-zA-z0-9@$!%*#?&]*$")
    @Column(nullable = false)
    String pw;
    //@OneToMany(mappedBy = "chatRoom")
    //@JsonIgnore
    //private List<MemberChatRooms> memberChatRooms = new ArrayList<>();

    //@OneToMany
//    @ElementCollection // ChatRoom 객체로 OneToMany는 불가능???  public void MemberRoomCreate(String chatRoomId) {
//    private List<String> chatRoomList = new ArrayList<>();    this.chatRoomList.add(chatRoomId); }

    public Member(String name, String pw) {
        this.name = name;
        this.pw = pw;
    }

//    public void MemberRoomCreate(ChatRoom chatRoom) {
//        this.memberChatRooms.add(chatRoom);
//    }

//    public void MemberRoomCreate(String chatRoomId) {
//        this.chatRoomList.add(chatRoomId);
//    }

    //    @Column(nullable = false)
//    @Enumerated(value = EnumType.STRING)
//    MemberEnum role;
//
//    @Transient // 이거하면 컬럼에서 제외 시킬 수 있음
//    String adminToken;
}
