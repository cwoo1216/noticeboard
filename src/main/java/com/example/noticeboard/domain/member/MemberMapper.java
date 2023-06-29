package com.example.noticeboard.domain.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    MemberResponse findByLoginId(String loginId);

}
