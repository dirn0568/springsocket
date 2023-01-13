package com.sparta.springcrud0.controller;

import com.sparta.springcrud0.dto.MemberResponseDto;
import com.sparta.springcrud0.dto.ResponseDto;
import com.sparta.springcrud0.entity.Member;
import com.sparta.springcrud0.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


@Controller
@RequiredArgsConstructor // 어노테이션 알아보기 final붙어있는거 이어준다 생성자를 만들어준다
public class MemberController {
    //@Autowired // spring di 생성자가 필요했는데 @RequiredArgsConstructor, final 이거를 통해서 생성했었음 이거를 사용하기 싫으면 @Autowired 작성
    private final MemberService memberService; // final을 쓴다는건 무조건 사용을 하겠다는것을 알려주는 것이다
                                                // 이게 없으면 사용을 안해도 된다고 프로그램이 생각한다
    @GetMapping("/member/{id}")
    @ResponseBody
    public MemberResponseDto getMemberInfo(@PathVariable Long id) {
        MemberResponseDto memberResponseDto = memberService.findMember(id);
        return memberResponseDto;
    }
    @GetMapping("/member")
    @ResponseBody
    public List<MemberResponseDto> getMemberList() {
        List<MemberResponseDto> memberResponseDto = memberService.findAllMember();
        return memberResponseDto;
    }

    //    public MemberController(MemberService memberService) {
    //        this.memberService = memberService;
    //    }

    @GetMapping("/register")
    @ResponseBody
    public ModelAndView RegisterGet() {
        ModelAndView mv = new ModelAndView("register");
        return mv;
    }
    @PostMapping("/api/register")
    @ResponseBody
    public Map RegisterPost(@RequestBody Member member) {
        Map registerMessage = memberService.RegisterPost(member);
        return registerMessage;
    }
    @GetMapping("/login")
    @ResponseBody
    public ModelAndView LoginGet() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
    @PostMapping("/api/login")
    @ResponseBody
    public ResponseDto LoginPost(@RequestBody Member member, HttpServletResponse response) {
        ResponseDto responseDto = memberService.LoginPost(member, response);
        return responseDto;
    }

    @GetMapping("/memberList")
    public String MemberList(Model model) {
        List<MemberResponseDto> memberResponseDto = memberService.findAllMember();
        model.addAttribute("memberList", memberResponseDto);
        return "chat/memberList";
    }
}
