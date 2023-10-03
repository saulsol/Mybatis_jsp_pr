package com.example.springboot_bit.service.impl;

import com.example.springboot_bit.entity.Board;
import com.example.springboot_bit.entity.Member;
import com.example.springboot_bit.myBatis.mapper.BoardMapper;
import com.example.springboot_bit.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
    // @RequiredArgsConstructor => private final

    @Override
    public List<Board> getList() {

        List<Board> list = boardMapper.getList();

        return list;
    }

    @Override
    public Member login(Member member) {
        Member activeMember = boardMapper.login(member);
        return activeMember;
    }

    @Override
    public void insertBoard(Board board) {
        boardMapper.insertSelectKey(board);
    }

    @Override
    public Board read(int idx) {
        return boardMapper.read(idx);
    }

    @Override
    public void update(Board board) {
        boardMapper.update(board);
    }

    @Override
    public void delete(int idx) {
        boardMapper.remove(idx);
    }

    // 권한이 있으면 TRUE
    // 권한이 없으면 FALSE
    public boolean deleteValidateCheck(HttpSession session, int idx){
        Member member = (Member) session.getAttribute("loginSuccess");
        Board find = boardMapper.read(idx);

        return member.getMemId().equals(find.getMemId());
    }

    public Boolean modifyValidateCheck(Board board, HttpSession session){
        Member member = (Member) session.getAttribute("loginSuccess");
        return member.getMemId().equals(board.getMemId());
    }
}
