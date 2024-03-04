package org.startup.diabetes.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
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
import java.util.Map;


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

    //@Valid로 유효성 검사하기
//    @PostMapping("/register")
//    public String registerPost(@Valid FastingDTO fastingDTO, Errors errors, Model model,
//                               RedirectAttributes redirectAttributes) {
//        if (errors.hasErrors()) {
//            /* 공복혈당 입력 실패시 입력 데이터 값을 유지 */
//            model.addAttribute("fastingDTO", fastingDTO);
//            /* 유효성 통과 못한 필드와 메시지를 핸들링 */
//            Map<String, String> validatorResult = fastingService.validateHandling(errors);
//            for (String key : validatorResult.keySet()) {
//                model.addAttribute(key, validatorResult.get(key));
//            }
//
//            log.info(fastingDTO);
//            return "redirect:/fasting/register"; // 실패 시 리다이렉트
//        }
//
//        /* 공복혈당 성공시 처리 */
//        Long bno = fastingService.register(fastingDTO);
//        redirectAttributes.addFlashAttribute("result", bno);
//        return "redirect:/fasting/register"; // 성공 시 리다이렉트
//    }

    //post register 정상작동
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

    @GetMapping("/chart")
    public void highlightGET(){
    }


}
