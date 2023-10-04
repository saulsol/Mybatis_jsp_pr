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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String get(@RequestParam("idx") int idx, Model model, HttpSession session,
                      RedirectAttributes attributes, HttpServletRequest request, HttpServletResponse response){

        if(session.getAttribute("loginSuccess") == null){
            attributes.addFlashAttribute("result", "로그인을 먼저 해야합니다.");
            return "redirect:/board/list";
        }


        // 조회수 증가
        Cookie[] cookies = request.getCookies();
        Cookie visitCookie = null;
        for(Cookie cookie : cookies){
            if(cookie.getName().contains("visit_cookie"+request.getParameter("idx"))){
                visitCookie = cookie;
                break;
            }
        }

        if(visitCookie != null && visitCookie.getValue().equals(request.getParameter("idx"))){
            visitCookie.setValue(request.getParameter("idx"));
            visitCookie.setMaxAge(60 * 60 * 2);
            response.addCookie(visitCookie);
        }else {
            Cookie newCookie = new Cookie("visit_cookie" + request.getParameter("idx"), request.getParameter("idx"));
            newCookie.setMaxAge(60 * 60 * 2);
            response.addCookie(newCookie);
            boardService.addBoardCount(idx);
        }




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


    @GetMapping("/reply")
    public String reply(@RequestParam ("idx") int idx, Model model){
        Board read = boardService.read(idx);
        model.addAttribute("read", read);
        return "comment";
    }

    @PostMapping("/reply")
    public String reply(@ModelAttribute Board board){

        return "redirect:/board/list";
    }

}
