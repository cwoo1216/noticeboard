package com.example.noticeboard.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 작성
    @PostMapping("/boards/{playerId}/comments")
    public CommentResponse saveComment(@PathVariable final Long playerId, @RequestBody final CommentRequest params) {
        Long id = commentService.saveComment(params);
        return commentService.findCommentById(id);
    }

    // 댓글 리스트
    @GetMapping("/boards/{playerId}/comments")
    public List<CommentResponse> findAllComment(@PathVariable final Long playerId){
        return commentService.findAllComment(playerId);
    }

    // 댓글 상세정보
    @GetMapping("/boards/{playerId}/comments/{id}")
    public CommentResponse findCommentById(@PathVariable final Long playerId, @PathVariable final Long id){
        return commentService.findCommentById(id);
    }

    // 댓글 수정
    @PatchMapping("/boards/{playerId}/comments/{id}")
    public CommentResponse updateComment(@PathVariable final Long playerId, @PathVariable final Long id, @RequestBody final CommentRequest params){
        commentService.updateComment(params);
        return commentService.findCommentById(id);
    }

    // 댓글 삭제
    @DeleteMapping("/boards/{playerId}/comments/{id}")
    public Long deleteComment(@PathVariable final Long playerId, @PathVariable final Long id){
        return commentService.deleteComment(id);
    }
}
