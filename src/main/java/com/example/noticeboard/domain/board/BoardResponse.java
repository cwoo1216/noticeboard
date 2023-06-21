package com.example.noticeboard.domain.board;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponse {

    private Long id;                    // id - auto increment
    private String event;               // 종목
    private String name;                // 선수 이름
    private String location;            // 포지션
    private String backNo;              // 등번호
    private String birth;               // 생일
    private String preference;          // 선호 - 오른발 왼발 (손)
    private String nation;              // 국적
    private String team;                // 소속팀
    private String writer;              // 작성자
    private LocalDateTime createdTime;  // 생성일시
    private LocalDateTime modifiedTime; // 최종 수정일시
    private Boolean deleteYn;           // 삭제 여부

}
