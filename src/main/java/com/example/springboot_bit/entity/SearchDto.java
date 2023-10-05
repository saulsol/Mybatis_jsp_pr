package com.example.springboot_bit.entity;

import lombok.*;

@Getter
@Setter
@ToString
public class SearchDto {

    PageInfo pageInfo;
    PostSearch search;

    @Builder
    public SearchDto(PageInfo pageInfo, PostSearch search) {
        this.pageInfo = pageInfo;
        this.search = search;
    }
}
