package org.startup.diabetes.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.startup.diabetes.dto.MemberJoinDTO;
import org.startup.diabetes.service.MemberService;

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


    @GetMapping("/join")
    public void memberGET() {
        log.info("join get---------------");
    }

    @PostMapping("/join")
    public String memberPOST( MemberJoinDTO memberJoinDTO, RedirectAttributes redirectAttributes) {

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


//    @GetMapping("/user-id/{userid}/exist")
//    public ResponseEntity<Boolean> checkUseridDuplicate(@PathVariable String userid) {
//
//        return ResponseEntity.ok(memberService.checkUseridDuplicate());
//    }
}
