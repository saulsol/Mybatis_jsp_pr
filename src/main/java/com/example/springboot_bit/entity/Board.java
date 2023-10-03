package com.example.springboot_bit.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private int idx; // 게시물 번호
    private String memId; // 회원 id
    private String title; // 제목
    private String content; // 내용
    private String writer; // 작성자
    private Date inDate; // 작성일
    private int count; // 조회수
    private int boardGroup; //부모글과 답글을 묶는 역할
    private int boardSequence; // 부모글과 자식글을 나누는 기준점
    private int boardLevel; // 답글의 레벨(들여쓰기)
    private int boardAvailable; // 삭제된 글인지 여부
}
