package org.startup.diabetes.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/page")
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

}