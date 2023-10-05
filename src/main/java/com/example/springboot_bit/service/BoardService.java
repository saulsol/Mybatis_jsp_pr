package com.example.springboot_bit.service;

import com.example.springboot_bit.entity.*;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface BoardService {
    public List<Board> getList(PageInfo pageInfo);

    public Member login(Member member);

    public void insertBoard(Board board);

    public Board read(int idx);

    public void update(Board board);

    public void delete(int idx);
    public boolean deleteValidateCheck(HttpSession session, int idx);
    public Boolean modifyValidateCheck(Board board, HttpSession session);

    public void replyProcess(Board board);

    public void addBoardCount(int idx);

    public void insertComment(Comment comment);

    public List<Comment> findByBoardId(int boardId);

    public void insertMember(Member member);

    public String duplicateMemberCheck(String memId);

    public int totalCount();

    public List<Board> searchBoard(SearchDto search);

    public int searchCount(PostSearch search);

}
