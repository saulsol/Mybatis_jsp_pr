package com.example.springboot_bit.myBatis.mapper;

import com.example.springboot_bit.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<Board> getList();
}
