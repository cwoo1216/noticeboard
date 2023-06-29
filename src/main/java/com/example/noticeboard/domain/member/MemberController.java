package com.example.noticeboard.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 로그인 페이지
    @GetMapping("/board/login")
    public String openLongin(){
        return "board/login";
    }

    // 로그인
    @PostMapping("/login")
    @ResponseBody
    public MemberResponse login(HttpServletRequest request) {
        //회원 정보 조회
        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");
        MemberResponse member = memberService.login(loginId, password);

        if (member != null){
            HttpSession session = request.getSession();
            session.setAttribute("loginMember", member);
            session.setMaxInactiveInterval(60*30);
        }
        return member;
    }

    // 로그아웃
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.do";
    }

    // 회원 정보 조히
    @GetMapping("/login/{loginId}")
    @ResponseBody
    public MemberResponse findMemberByLoginId(@PathVariable final String loginId){
        return memberService.findMemberByLoginId(loginId);
    }
}
