package com.example.springboot_bit.entity;

import lombok.*;

// 페이징 처리를 만드는 클래스
@Getter
@ToString
public class PageMaker {

    @Setter
    private PageInfo pageInfo;
    private int totalCount;  // 총 게시글의 수
    private int startPage; // 시작 페이지 번호
    private int endPage;
    private boolean prev; // true -> 이전 있음 , false -> 이전 없음
    private boolean next; // true -> 다음 있음, false -> 다음 없음
    private final int DISPLAY_PAGE_NUM = 5; // 하단에 몇개의 페이지를 보여줄 것인가?
    private int realEndPage;

    public void setTotalCount(int totalCount){
        this.totalCount = totalCount;
        makePaging();
    }

    private void makePaging() {
        // 1. 화면에 보여질 마지막 페이지 번호
        endPage = (int) (Math.ceil(pageInfo.getPage()/(double)DISPLAY_PAGE_NUM) * DISPLAY_PAGE_NUM);

        // 2. 화면에 보여질 시작 페이지 번호
        startPage = (endPage - DISPLAY_PAGE_NUM) + 1;
        if(startPage <= 0) startPage = 1;

        // 3. 전체 마지막 페이지 계산
        realEndPage = (int)(Math.ceil(totalCount/(double)pageInfo.getPerPageNum()));

        //4. 화면에 보여질 마지막 페이지 유효성 체크
        if(realEndPage<endPage){
            endPage = realEndPage;
        }
        
        //5. 다음 페이지 존재 여부
        next = (endPage<realEndPage)? true : false;
        
        // 6. 이전 페이지 버튼(링크) 존재 여부
        prev = (startPage==1) ? false : true;
    }


}
