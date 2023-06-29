package com.example.noticeboard.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberResponse findMemberByLoginId(final String loginId) {
        return memberMapper.findByLoginId(loginId);
    }

    // 로그인
    public MemberResponse login(final String loginId, final String password) {
        // 아이디 비번 조회
        MemberResponse member = findMemberByLoginId(loginId);
        String passwordNum = (member == null) ? "" : member.getPassword();
        return member;
    }
}
