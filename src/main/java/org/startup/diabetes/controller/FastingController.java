package org.startup.diabetes.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.startup.diabetes.domain.Fasting;
import org.startup.diabetes.dto.FastingDTO;
import org.startup.diabetes.dto.PageRequestDTO;
import org.startup.diabetes.dto.PageResponseDTO;
import org.startup.diabetes.service.FastingService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/fasting")
public class FastingController {

    private final FastingService fastingService;

//    @GetMapping("/register")
//    public void registerGET(){}

    @GetMapping("/register")
    public void registerGET(){

    }

    @PostMapping("/register")
    public String registerPost(@Valid FastingDTO fastingDTO, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        log.info("board POST register..........");

            if (bindingResult.hasErrors()) {
                log.info("has errors.....");
                redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
                return "redirect:/fasting/register";
            }
            log.info(fastingDTO);

            Long bno = fastingService.register(fastingDTO);
            redirectAttributes.addFlashAttribute("result", bno);

            return  "redirect:/fasting/register";
        }

//    @PostMapping("/register")
//    public String registerPost(@ModelAttribute FastingDTO fastingDTO,RedirectAttributes redirectAttributes){
//        log.info("board POST register..........");
//        System.out.println("fastingDTO 저장" + fastingDTO);
//
//        return  "redirect:/fasting/register";
//    }

//    @GetMapping("/list")
//    public void list(PageRequestDTO pageRequestDTO, Model model){
//
//        PageResponseDTO<FastingDTO> responseDTO = fastingService.list(pageRequestDTO);
//        log.info(responseDTO);
//
//        //화면 목록에 목록 데이터 출력
//        model.addAttribute("responseDTO", responseDTO);
//
//        //List<String> list = Arrays.asList("AAA", "BBB", "CCCC");
//        //model.addAttribute("list", list);
//    }

}
