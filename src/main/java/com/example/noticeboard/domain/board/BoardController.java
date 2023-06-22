package com.example.noticeboard.domain.board;

import com.example.noticeboard.common.dto.MessageDto;
import com.example.noticeboard.common.dto.SearchDto;
import com.example.noticeboard.common.paging.PagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "common/messageRedirect";
    }

    // 쿼리 스트링 파라미터 MAP
    private Map<String, Object> queryParamsToMap(final SearchDto queryParams){
        Map<String, Object> data = new HashMap<>();
        data.put("page", queryParams.getPage());
        data.put("recordSize", queryParams.getRecordSize());
        data.put("pageSize", queryParams.getPageSize());
        data.put("searchCategory", queryParams.getSearchCategory());
        data.put("searchType", queryParams.getSearchType());
        data.put("keyword", queryParams.getKeyword());
        return data;
    }

    // 게시글 작성
    @GetMapping("/board/write.do")
    public String openBoardWrite(@RequestParam(value = "id", required = false) final Long id, Model model){
        if (id !=null){
            BoardResponse board = boardService.findBoardById(id);
            model.addAttribute("board", board);
        }
        return "board/write";
    }

    // 신규 게시글 생성
    @PostMapping("/board/save.do")
    public String saveBoard(final BoardRequest params, Model model) {
        boardService.saveBoard(params);
        MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/board/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 게시글 리스트
    @GetMapping("/board/list.do")
    public String openBoardList(@ModelAttribute("params") final SearchDto params, Model model, String searchCategory){
        PagingResponse<BoardResponse> response;
//        System.out.println(searchCategory);
        // 검색 종목이 없을 때
        if (searchCategory == null || searchCategory.equals("")){
            response = boardService.findAllBoard(params);
        } else { //검색 종목이 있을 때
            response = boardService.findAllBoardByCategory(params);
        }
        model.addAttribute("response", response);
        return "board/list";
    }

    // 게시글 상세 페이지
    @GetMapping("/board/view.do")
    public String openBoardView(@RequestParam final Long id, Model model){
        BoardResponse board = boardService.findBoardById(id);
        model.addAttribute("board", board);
        return "board/view";
    }

    // 게시글 수정
    @PostMapping("/board/update.do")
    public String updateBoard(final BoardRequest params, Model model) {
        boardService.updateBoard(params);
        MessageDto message = new MessageDto("게시글 수정이 완료되었습니다.", "/board/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 게시글 삭제
    @PostMapping("/board/delete.do")
    public String deleteBoard(@RequestParam final Long id, final SearchDto queryParams,Model model){
        boardService.deleteBoard(id);
        MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다.", "/board/list.do", RequestMethod.GET, queryParamsToMap(queryParams));
        return showMessageAndRedirect(message, model);
    }
}
