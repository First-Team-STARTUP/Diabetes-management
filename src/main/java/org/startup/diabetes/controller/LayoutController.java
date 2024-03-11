package org.startup.diabetes.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.startup.diabetes.dto.FastingDTO;

import java.time.LocalDate;

@Log4j2
@Controller
public class LayoutController {

//    @RequestMapping("/page/home")
//    public String hello(){
//        return "/page/home.html";
//    }

    // "/home" 경로로의 GET 요청이 발생하면
    // "page/home"이라는 view를 찾아 클라이언트 반환 컨트롤러 메서드
    @RequestMapping(value = "/home", method= RequestMethod.GET)
    public String goHome(HttpServletRequest request) {

        return "page/home";
    }

    @GetMapping({"/intro"})
    public String introGET(){
        return "/fasting/intro.html";
    }

    @GetMapping({"/service"})
    public String serviceGET(){
        log.info("당당히 서비스 소개 페이지.............");
        return "/fasting/service";
    }

    @PostMapping("/service")
    public String servicePost(){
        log.info("당당히 서비스 이용하기 이동하기.............");
        return "redirect:/fasting/register";
    }

}