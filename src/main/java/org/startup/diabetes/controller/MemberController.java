package org.startup.diabetes.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
import org.startup.diabetes.config.WebSecurityConfig;
import org.startup.diabetes.dto.MemberDTO;
import org.startup.diabetes.dto.MemberLoginDTO;
import org.startup.diabetes.service.MemberService;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/login")
    public void loginGet(String errorCode, String logout){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        log.info("Logged in user: " + username);

        // 로그아웃 여부 확인
        log.info("logout: " + logout);
        if (errorCode != null && !errorCode.isEmpty()) {
            log.info("login error : " + errorCode );
        }

        // 에러 코드 확인
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

    @PreAuthorize(" #memberDTO.userid == principal.username")
    @GetMapping("/mypage/{userid}")
    public String mypage(@PathVariable String userid, Model model, @AuthenticationPrincipal UserDetails userDetails) {
        String currentUserid = userDetails.getUsername();

        // 사용자의 아이디를 기반으로 정보 조회
        MemberDTO dto = memberService.readMyPage(userid);

        // 현재 로그인한 사용자가 요청된 사용자의 정보를 볼 수 있는 권한을 가지고 있는지 확인
        if (!currentUserid.equals(userid)) {
            // 현재 사용자가 요청된 사용자의 정보를 볼 수 있는 권한이 없는 경우
            throw new AccessDeniedException("You are not allowed to access this page");
        }

        // 조회된 정보를 모델에 추가하여 뷰로 전달
        model.addAttribute("dto", dto);

        return "/member/mypage";
    }
    @PreAuthorize("#memberDTO.userid == principal.username")
    @PostMapping("/mypage")
    public String modifyMyPage(@Valid MemberDTO memberDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        log.info("회원 정보 변경 post" + memberDTO);


        if (bindingResult.hasErrors()) {
            log.info(" 에러가 있습니다. ");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("userid", memberDTO.getUserid());

            return "redirect:/member/mypage";
        }else {
            log.info("회원정보가 수정되었습니다.");

            memberService.modifyUser(memberDTO);
            redirectAttributes.addFlashAttribute("result", "modified");
            redirectAttributes.addAttribute("userid", memberDTO.getUserid());
        }

        return "redirect:/";

    }


    @PreAuthorize("#memberDTO.userid == principal.username")
    @PostMapping("/remove")
    public String removeUser(MemberDTO memberDTO, RedirectAttributes redirectAttributes){

        String userid = memberDTO.getUserid();
        log.info("remove 유저"+ userid);

        memberService.removeUser(userid);

        redirectAttributes.addFlashAttribute("result", "removed");

        return "redirect:/member/login";
    }

}
