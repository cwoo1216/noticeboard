package com.example.noticeboard.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;

    // 댓글 저장
    @Transactional
    public Long saveComment(final CommentRequest params) {
        commentMapper.save(params);
        return params.getId();
    }

    // 댓글 정보 조회
     public CommentResponse findCommentById(final Long id){
        return commentMapper.findById(id);
     }

     // 댓글 수정
    @Transactional
    public Long updateComment(final CommentRequest params) {
        commentMapper.update(params);
        return params.getId();
    }

    // 댓글 삭제
    @Transactional
    public Long deleteComment(final Long id){
        commentMapper.deleteById(id);
        return id;
    }

    // 댓글 리스트
    public List<CommentResponse> findAllComment(final Long playerId) {
        return commentMapper.findAll(playerId);
    }
}
