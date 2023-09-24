package com.example.springboot_bit.service.impl;

import com.example.springboot_bit.entity.Board;
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
}
