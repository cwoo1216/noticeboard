package com.example.noticeboard.domain.member;

import lombok.Getter;

@Getter
public class MemberResponse {

    private Long id;                       // 회원 번호
    private String loginId;                // 로그인 ID
    private String password;               // 비밀번호
    private String name;                   // 이름

}
