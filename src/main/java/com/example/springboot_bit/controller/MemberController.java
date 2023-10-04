package com.example.springboot_bit.controller;

import com.example.springboot_bit.entity.Member;
import com.example.springboot_bit.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final BoardService boardService;

    @GetMapping("/register")
    public String memberRegister(){
        return "memberRegister";
    }

    @PostMapping("/register")
    public String memberRegister(@ModelAttribute Member member){
        log.info( "::::::" + member.toString());
        boardService.insertMember(member);
        return "redirect:/board/list";
    }

    @PostMapping("/check")
    public void duplicateIdCheck(@RequestParam(name = "id") String memId, HttpServletResponse response) throws IOException {
        log.info("받아온 값"+memId);

        String data;

        if(boardService.duplicateMemberCheck(memId) != null){ // 이미 존재하는 경우
            data = "YES";
        }else {
            data = "NO"; // 중복이 아님
        }
        response.getWriter().print(data);
    }





}
