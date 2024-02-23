package org.startup.diabetes.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.startup.diabetes.dto.MemberJoinDTO;
import org.startup.diabetes.service.MemberService;

@Controller
@RequiredArgsConstructor
@Log4j2
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public String main(){

        return "main";
    }

    @GetMapping("/member/join")
    public void memberGET(){
        log.info("joinget");
    }

    @PostMapping("/member/join")
    public String memberPOST(MemberJoinDTO memberJoinDTO, RedirectAttributes redirectAttributes){

        memberService.join(memberJoinDTO);

        redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/";
    }
}
