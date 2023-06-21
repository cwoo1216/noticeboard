package com.example.noticeboard.domain.board;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    void save(BoardRequest params);             // 게시글 저장
    void update(BoardRequest params);           // 게시글 수정
    void deleteById(Long id);                   // 게시글 삭제

    BoardResponse findById(Long id);            // 게시글 정보 조회
    List<BoardResponse> findAll();              // 게시글 리스트

}
