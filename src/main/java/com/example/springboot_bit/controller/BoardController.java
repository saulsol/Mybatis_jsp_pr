package com.example.springboot_bit.controller;

import com.example.springboot_bit.entity.Board;
import com.example.springboot_bit.service.BoardService;
import com.example.springboot_bit.service.impl.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;
    @GetMapping("/list")
    public String list(Model model){
        List<Board> list = boardService.getList();
        model.addAttribute("boardList", list);
        System.out.println( "idx :::: " + list.get(0).getIdx());
        log.info("결과값 : {}", list.get(0));
        return "list";
    }



}
