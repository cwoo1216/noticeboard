package com.example.noticeboard.domain.board;

import com.example.noticeboard.common.dto.SearchDto;
import com.example.noticeboard.common.paging.Pagination;
import com.example.noticeboard.common.paging.PagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
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
    public PagingResponse<BoardResponse> findAllBoard(final SearchDto params) {

        // 데이터가 없는 경우 //
        int count = boardMapper.count(params);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        // 페이지 정보 저장 //
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        // 리스트 데이터 조회 후 데이터 응답 반환 //
        List<BoardResponse> list = boardMapper.findAll(params);
        return new PagingResponse<>(list, pagination);
    }

    // 게시글 리스트 - 카테고리
    public PagingResponse<BoardResponse> findAllBoardByCategory(final SearchDto params) {

        // 데이터가 없는 경우 //
        int count = boardMapper.countByCategory(params);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        // 페이지 정보 저장 //
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        // 리스트 데이터 조회 후 데이터 응답 반환 //
        List<BoardResponse> list = boardMapper.findAllByCategory(params);
        return new PagingResponse<>(list, pagination);
    }
}
