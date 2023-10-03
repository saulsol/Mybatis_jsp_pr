package com.example.springboot_bit.controller;

import com.example.springboot_bit.entity.Board;
import com.example.springboot_bit.service.BoardService;
import com.example.springboot_bit.service.impl.BoardServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
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

    @GetMapping("/register")
    public String getRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute Board board, RedirectAttributes attributes){
        boardService.insertBoard(board);
        attributes.addFlashAttribute("result", board.getIdx()+"번 글이 저장되었습니다.");
        return "redirect:/board/list";
    }

    @GetMapping("/get")
    public String get(@RequestParam("idx") int idx, Model model){
        Board read = boardService.read(idx);
        model.addAttribute("read", read);
        return "detail";
    }

    @GetMapping("/modify")
    public String modify(@RequestParam("idx") int idx, Model model){
        Board read = boardService.read(idx);
        model.addAttribute("read", read);
        return "modify";
    }

    @PostMapping("/modify")
    public String modify(@ModelAttribute Board board, RedirectAttributes attributes, HttpSession session){
        if(boardService.modifyValidateCheck(board, session)){
            boardService.update(board);
            attributes.addFlashAttribute("result", board.getIdx() + "번 글이 수정되었습니다.");
            return "redirect:/board/list";
        }

        attributes.addFlashAttribute("result", "수정 권한이 없습니다.");
        return "redirect:/board/list";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("idx") int idx, RedirectAttributes attributes, HttpSession session){

        if(boardService.deleteValidateCheck(session, idx)){
            boardService.delete(idx);
            attributes.addFlashAttribute("result", idx + "번 글이 삭제되었습니다.");
            return "redirect:/board/list";
        }

        boardService.delete(idx);
        attributes.addFlashAttribute("result", "삭제 권한이 없습니다.");
        return "redirect:/board/list";
    }


}
