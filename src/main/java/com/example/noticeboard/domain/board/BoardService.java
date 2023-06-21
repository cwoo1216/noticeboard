package com.example.noticeboard.domain.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    // 게시글 저장
    @Transactional
    public Long saveBoard(final BoardRequest params){
        boardMapper.save(params);
        return params.getId();
    }

    // 게시글 정보 조회
    @Transactional
    public BoardResponse findBoardById(final Long id) {
        return boardMapper.findById(id);
    }

    // 게시글 수정
    @Transactional
    public Long updateBoard(final BoardRequest params) {
        boardMapper.update(params);
        return params.getId();
    }

    // 게시글 삭제
    public Long deleteBoard(final Long id) {
        boardMapper.deleteById(id);
        return id;
    }

    // 게시글 리스트
    public List<BoardResponse> findAllBoard() {
        return boardMapper.findAll();
    }
}
