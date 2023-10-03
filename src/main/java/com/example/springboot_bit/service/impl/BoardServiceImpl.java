package com.example.springboot_bit.service.impl;

import com.example.springboot_bit.entity.Board;
import com.example.springboot_bit.entity.Member;
import com.example.springboot_bit.myBatis.mapper.BoardMapper;
import com.example.springboot_bit.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
