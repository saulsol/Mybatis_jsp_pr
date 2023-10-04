package com.example.springboot_bit.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private int commentId;
    private int boardId;
    private String memId;
    private String memName;
    private Date inDate; // 작성일
    private String title; // 제목
    private String content; // 내용



}
