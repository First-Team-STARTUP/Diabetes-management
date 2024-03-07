package org.startup.diabetes.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.startup.diabetes.dto.MemberDTO;
import org.startup.diabetes.dto.MemberPwUpdateDTO;
import org.startup.diabetes.service.MemberService;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final BCryptPasswordEncoder passwordEncoder;


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

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/mypage")
    public String mypage(Model model, @AuthenticationPrincipal UserDetails userDetails) {

        // @AuthenticationPrincipal을 통해 현재 사용자의 UserDetails를 가져옴
        String currentUserid = userDetails.getUsername();

        // 사용자의 아이디를 기반으로 정보 조회
        MemberDTO dto = memberService.readMyPage(currentUserid);

        // 조회된 정보를 모델에 추가하여 뷰로 전달
        model.addAttribute("dto", dto);

        return "/member/mypage";
    }

    @PostMapping("/mypage")
    public String modifyMyPage(@Valid MemberDTO memberDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

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

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/change-password")
    public String showChangePasswordPage(Authentication authentication, Model model) {

        // @AuthenticationPrincipal을 통해 현재 사용자의 UserDetails를 가져옴
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // 사용자의 아이디를 기반으로 정보 조회
        MemberDTO dto = memberService.readMyPage(userDetails.getUsername());

        // 조회된 정보를 모델에 추가하여 뷰로 전달
        model.addAttribute("dto", dto);


        return "/member/change-password"; // 변경할 비밀번호 입력 페이지의 뷰 이름
    }

    @PostMapping("/change-password")
    public String changePassword(@Valid MemberPwUpdateDTO dto,
                                 Model model,
                                 Authentication authentication) {
        if (!Objects.equals(dto.getNewPw(), dto.getConfirmPw())) {
            model.addAttribute("dto", dto);
            model.addAttribute("differentPassword", "비밀번호가 같지 않습니다.");
            return "/member/mypage";
        }


        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String result = memberService.changePassword(dto, userDetails.getUsername());

        if (result == null){
            model.addAttribute("dto", dto);
            model.addAttribute("wrongPassword", "비밀번호가 맞지 않습니다.");
            return "/member/mypage";
        }

        return "redirect:/member/mypage";

    }


//    @PreAuthorize("#memberDTO.userid == principal.username")
    @PostMapping("/remove")
    public String removeUser(@Valid MemberDTO memberDTO, RedirectAttributes redirectAttributes, @AuthenticationPrincipal UserDetails userDetails) {
        // 회원 정보를 DTO로부터 가져옵니다.
//        String userid = memberDTO.getUserid();
//        log.info("remove 유저"+ userid);

        // 서비스 레이어에서 회원을 삭제하는 메서드를 호출합니다.
        try {
           String userid = memberService.removeUser(memberDTO, userDetails);
            redirectAttributes.addFlashAttribute("message", "회원 탈퇴가 완료되었습니다.");
            redirectAttributes.addFlashAttribute("userid", userid);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "회원 탈퇴 중 오류가 발생했습니다.");
            return "redirect:/member/mypage";
        }

        // 회원 삭제 후 리다이렉트할 URL을 반환합니다.
        return "redirect:/member/delete-member";
    }

    @GetMapping("/delete-member")
    public String deleteUserCheck(){
        return "/member/delete-member";
    }



//    // 비밀번호 변경 폼 보여주기
//    @GetMapping("/change-password")
//    public String showChangePasswordForm() {
//        return "change-password-form";
//    }

    // 비밀번호 변경


}


