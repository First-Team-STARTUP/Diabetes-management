package org.startup.diabetes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.startup.diabetes.dto.FastingDTO;
import org.startup.diabetes.service.FastingService;

import java.io.IOException;


@Controller
@RequiredArgsConstructor
@RequestMapping("/fasting")
public class FastingController {

    private final FastingService fastingService;

    @GetMapping("/register")
    public String fastingForm() {
        return "register";
    }

    @PostMapping("/register")
    public String save(@ModelAttribute FastingDTO fastingDTO) throws IOException {
        System.out.println("fastingDTO =" + fastingDTO);
        fastingService.register(fastingDTO);
        return null;
    }

}
