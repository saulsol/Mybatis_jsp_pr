package com.example.springboot_bit.service.impl;

import com.example.springboot_bit.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BoardServiceImplTest {

    @Autowired
    BoardService boardService;

//    @Test
//    public void testGetList(){
//        boardService.getList().forEach(board -> {
//            log.info(board.toString());
//        });
//    }

}