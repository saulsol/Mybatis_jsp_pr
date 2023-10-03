package com.example.springboot_bit.myBatis.mapper;

import com.example.springboot_bit.entity.Board;
import com.example.springboot_bit.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<Board> getList();

    public void insert(Board board);

    public void insertSelectKey(Board board);

    public Member login(Member member);

    public Board read(int idx);

    public void update(Board board);

    public void remove(int idx);
}
