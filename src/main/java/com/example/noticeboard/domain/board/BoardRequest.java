package com.example.noticeboard.domain.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequest {

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
}
