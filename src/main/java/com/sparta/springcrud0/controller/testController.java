package com.sparta.springcrud0.controller;

import com.sparta.springcrud0.entity.Board;
import com.sparta.springcrud0.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

//@ResponseBody // HTML을 못받음
@Controller
@RequiredArgsConstructor // 이게 뭘까???
@RequestMapping("/test")
public class testController {
    private final BoardRepository boardRepository;

    @GetMapping("/{id}") // @ResponseBody를 쓰면 detail.html이 아닌 detail 문자열을 받음
    public String home(Model model, @PathVariable Long id) {
        Board board = boardRepository.findById(id).orElseThrow();
        model.addAttribute(board);
        return "detail"; // view + data passvariable, @RequestParam, @ModelAttribute
    }

    @GetMapping(value = "/hello")
    public String hello(ModelMap model){
        model.addAttribute("text", "hello ModelMap");
        return "jsonView";
    }

    @GetMapping("api/post/{id}")
    public String boardDetail(@PathVariable Long id) {
        System.out.println("여기로 이동이 됨????");
        return "detail2";
    }
    @GetMapping("/test") // prg패턴, 새로고침과 리다이렉트는 다르다
    public String moveDetail() {
        return "redirect:api/post/1";
    }

    @GetMapping("/hello2") // prg패턴, 새로고침과 리다이렉트는 다르다
    public String hello2() {
        return "redirect:api/post/1";
    }

    @GetMapping("/rhelo")
    public String rhelo(HttpServletResponse response) {
        System.out.println("---------------test1231------------------");
        System.out.println(response.getHeader("tomhdw"));
        System.out.println("---------------test1231------------------");
        response.addHeader("tomhdw", "testsuccess"); // 어차피 resposne가 넘어가기 떄문에 거기 헤더에 직접 넣어줬다
        return "success";
    }
}
