package com.example.springboot_bit.entity;

import lombok.*;

@Getter
@Setter
@ToString
public class PageInfo {

    private int page; // 현재 페이지 번호
    private int perPageNum;// 한 페이지에 보여줄 게시글의 수

    // 기본 세팅
    public PageInfo() {
        this.page = 1;
        this.perPageNum = 5;
    }

    // 현재 페이지의 게시글의 시작 번호
    public int getPageStart(){
        return (page -1) * perPageNum;
    }

    // 1 page -> 0 ~ 9


}
