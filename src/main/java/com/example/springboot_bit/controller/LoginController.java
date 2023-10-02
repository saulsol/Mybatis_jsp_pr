package com.example.springboot_bit.controller;

import com.example.springboot_bit.entity.Member;
import com.example.springboot_bit.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
@Slf4j
@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final BoardService boardService;

    @PostMapping("/loginProcess")
    public String login(@ModelAttribute Member member, HttpSession session){
        Member loginSuccessMember = boardService.login(member);
        log.info("login SUCESS!!  {}", loginSuccessMember.toString());

        if(loginSuccessMember != null){ // 로그인 성공
            session.setAttribute("loginSuccess", loginSuccessMember);
        }


        return "redirect:/board/list";
    }

    @PostMapping("/logoutProcess")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/board/list";
    }

    // 포워딩을 하면 기존의 게시글을 GET 요청으로 담는데 해당 프로세스가 생략이 되어버린다
    // 로그아웃, 로그인 둘다 따라서 리다이렉트로 처리한다.

}
