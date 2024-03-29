package org.startup.diabetes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.startup.diabetes.dto.MemberDTO;
import org.startup.diabetes.service.MemberService;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MemberService memberService;

    @GetMapping("/")
    public String main( Model model, @AuthenticationPrincipal UserDetails userDetails) {

        // 현재 인증된 사용자의 아이디 가져오기
        String userid = userDetails != null ? userDetails.getUsername() : null;
        if (userid == null || userid.isEmpty()) {
            // 인증된 사용자가 없는 경우 로그인 페이지로 리다이렉트
            return "redirect:/member/login";
        } else {
            boolean dto = memberService.checkUseridDuplicate(userid);
            // 사용자 아이디를 모델에 추가하여 뷰로 전달
            model.addAttribute("dto", dto);
            return "main";
        }
    }
}
