package com.example.springboot_bit.controller;

import com.example.springboot_bit.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("boardList", boardService.getList());
        return "list";
    }



}
