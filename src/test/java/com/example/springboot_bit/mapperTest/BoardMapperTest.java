package com.example.springboot_bit.mapperTest;

import com.example.springboot_bit.entity.Board;
import com.example.springboot_bit.myBatis.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void getList(){
        List<Board> list = boardMapper.getList();
        for (Board board : list) {
            log.info(board.toString());
        }
    }


}
