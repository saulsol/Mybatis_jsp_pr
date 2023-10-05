package com.example.springboot_bit.service.impl;

import com.example.springboot_bit.entity.*;
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
    public List<Board> getList(PageInfo pageInfo) {

        List<Board> list = boardMapper.getList(pageInfo);

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

    @Override
    public void replyProcess(Board board) {

    }

    @Override
    public void addBoardCount(int idx) {
        boardMapper.addBoardCount(idx);
    }

    @Override
    public void insertComment(Comment comment) {
        boardMapper.insertComment(comment);
    }

    @Override
    public List<Comment> findByBoardId(int boardId) {
        return boardMapper.findByBoardId(boardId);
    }

    @Override
    public void insertMember(Member member) {
        boardMapper.insertMember(member);
    }

    @Override
    public String duplicateMemberCheck(String memId) {
        return boardMapper.duplicateMemberCheck(memId);
    }

    @Override
    public int totalCount() {
        return boardMapper.totalCount();
    }

    @Override
    public List<Board> searchBoard(SearchDto search) {
        return boardMapper.searchBoard(search);
    }

    @Override
    public int searchCount(PostSearch search) {
        return boardMapper.searchCount(search);
    }
}
