package org.startup.diabetes.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/")  //기본주소 요청이오면

    public String index() {  // 이 메소드가 호출이되고
        return "/board/index"; //index.html 뷰를 찾아간다. 하도록 만듬 컨트롤러단에서

    }
}
