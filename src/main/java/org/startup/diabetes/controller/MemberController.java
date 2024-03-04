package org.startup.diabetes.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.startup.diabetes.domain.Member;
import org.startup.diabetes.dto.MemberDTO;
import org.startup.diabetes.service.MemberService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/login")
    public void loginGet(String errorCode, String logout) {

        log.info("login get.....");
//        log.info("logout: " + logout);

        if (errorCode != null && !errorCode.isEmpty()) {
            log.info("login error : " + errorCode);
        }

        if (logout != null) {
            log.info("user logout........");
        }

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/join")
    public void memberGET() {
        log.info("join get---------------");
    }

    @PostMapping("/join")
    public String memberPOST( MemberDTO memberJoinDTO, RedirectAttributes redirectAttributes) {

        log.info("join Post~~~~");
        log.info("login member : " + memberJoinDTO);

        memberService.checkUseridDuplicate(memberJoinDTO.getUserid());

        try {
            memberService.join(memberJoinDTO);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "id");

            
            //"<script>alert('아이디 중복입니다')</script>"
            return "redirect:/member/join";
        }


        redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/";
    }

    @GetMapping("/mypage/{userid}")
    @PreAuthorize("#userid == authentication.name")
    public String  mypage(@PathVariable String userid, Model model) {
        log.info("Get My Page");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.isAuthenticated();
        // 사용자의 아이디를 기반으로 정보 조회
        MemberDTO dto = memberService.readMyPage(userid);

        // 조회된 정보를 모델에 추가하여 뷰로 전달
        model.addAttribute("dto", dto);

        return "/member/mypage";

    }


}
