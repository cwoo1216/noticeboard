package com.example.noticeboard.domain.comment;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    void save(CommentRequest params);                // 댓글 저장
    void update(CommentRequest params);              // 댓글 수정
    void deleteById(Long id);                        // 댓글 삭제
    CommentResponse findById(Long id);               // 댓글 정보 조회
    List<CommentResponse> findAll(Long playerId);    // 댓글 리스트


}
