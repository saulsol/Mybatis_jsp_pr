package com.example.springboot_bit.service;

import com.example.springboot_bit.entity.Board;
import com.example.springboot_bit.entity.Member;

import java.util.List;

public interface BoardService {
    public List<Board> getList();

    public Member login(Member member);

    public void insertBoard(Board board);

    public Board read(int idx);

    public void update(Board board);
}
