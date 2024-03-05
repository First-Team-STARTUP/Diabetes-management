package org.startup.diabetes.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.startup.diabetes.dto.FastingDTO;
import org.startup.diabetes.service.FastingService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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


    //오류 없는 register
    @PostMapping("/register")
    public String registerPost(@Valid FastingDTO fastingDTO, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        log.info("공복 혈당 등록..........");

        if (bindingResult.hasErrors()) {
            /* 실패시 데이터 값 유지*/
            log.info("혈당정보 등록 실패");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/fasting/register";
        }
        log.info(fastingDTO);

        Long bno = fastingService.register(fastingDTO);
        redirectAttributes.addFlashAttribute("result", bno);

        log.info("혈당정보 등록 완료");
        return  "redirect:/fasting/list";
    }

    // 리스트
    @GetMapping("/list")
    public String findAll(Model model){
        log.info("리스트 페이지..............");
        //여러개 가져올때 List<>
        //List<FastingDTO> FastingDTO를 List로
        //DB에서 전체 게시글 데이터를 가져와서  list.htrml에 보여준다.
        List<FastingDTO> fastingDTOList = fastingService.findAll();
        log.info("fastingDTOList 는" + fastingDTOList );
        // 가져온객체를 model에
        model.addAttribute("fastingList", fastingDTOList);
        return "/fasting/list";
    }

    //highlight  정상동작
//    @GetMapping("/highlight")
//    public String getHighlightPage(Model model) {
//        log.info("혈당정보 하이라이트 페이지.....");
//        List<FastingDTO> fastingDataList = fastingService.findAll();
//        log.info("fastingDataList 는" + fastingDataList);
//
//        // Thymeleaf에서 사용할 수 있도록 데이터를 모델에 추가
//        model.addAttribute("fastingDataList", fastingDataList);
//        // templates 폴더에 있는 highlight.html을 렌더링
//        return "/fasting/highlight";
//    }

    //highlight  수정
    @GetMapping("/highlight")
    public String getHighlightPage(Model model) {
        log.info("혈당정보 하이라이트 페이지.....");

        // 최근 7일의 데이터만 가져오기
        LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);
        List<FastingDTO> fastingDataList = fastingService.findAll()
                .stream()
                .filter(data -> data.getRegistDate().isAfter(sevenDaysAgo))
                .collect(Collectors.toList());

        log.info("fastingDataList 는" + fastingDataList);

        // Extracting emptyData and registDate arrays from fastingDataList
        List<Integer> emptyDataList = fastingDataList.stream()
                .map(FastingDTO::getEmptyData)
                .collect(Collectors.toList());
        log.info("emptyDataList 는" + emptyDataList);

        List<LocalDate> registDateList = fastingDataList.stream()
                .map(FastingDTO::getRegistDate)
                .collect(Collectors.toList());
        log.info("registDateList 는" + registDateList);

        // Thymeleaf에서 사용할 수 있도록 데이터를 모델에 추가
        model.addAttribute("fastingDataList", fastingDataList);
        model.addAttribute("emptyDataList", emptyDataList);
        model.addAttribute("registDateList", registDateList);

        // templates 폴더에 있는 highlight.html을 렌더링
        return "/fasting/highlight";
    }

}

