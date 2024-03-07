package org.startup.diabetes.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.startup.diabetes.dto.FastingDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.startup.diabetes.service.FastingService;

import java.time.LocalDate;
import java.util.Collections;
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
                               RedirectAttributes redirectAttributes, HttpServletRequest request, @AuthenticationPrincipal UserDetails userDetail){
        log.info("공복 혈당 등록..........");

        // 공복혈당 값 50~900범위 체크
        int emptyData = fastingDTO.getEmptyData();
        if (!fastingService.emptyDataRange(emptyData)) {
            redirectAttributes.addFlashAttribute("duplicateEmptyDataMessage", "공복혈당은 50에서 900 사이의 값이어야 합니다.");
            return "redirect:/fasting/register";
        }


        if (bindingResult.hasErrors()) {
            /* 실패시 데이터 값 유지*/
            log.info("날짜중복.... 공복혈당정보 등록 실패");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/fasting/register";
        }

        LocalDate registDate = fastingDTO.getRegistDate();

        // 중복 체크
        if (fastingService.registDateDuplicated(registDate)) {
            redirectAttributes.addFlashAttribute("duplicateMessage", "이미 등록된 날짜입니다.");
            return "redirect:/fasting/register";
        }

        log.info(fastingDTO);

        Long bno = fastingService.register(fastingDTO, userDetail);
        redirectAttributes.addFlashAttribute("result", bno);

        log.info("혈당정보 등록 완료");
        return  "redirect:/fasting/list";
    }

    // 리스트
    @GetMapping("/list")
    public String findAll(Model model, @AuthenticationPrincipal UserDetails userDetails){
        log.info("리스트 페이지..............");
        //여러개 가져올때 List<>
        //List<FastingDTO> FastingDTO를 List로
        //DB에서 전체 게시글 데이터를 가져와서  list.htrml에 보여준다.
        List<FastingDTO> fastingDTOList = fastingService.findByUserid(userDetails.getUsername());
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

    //highlight -> report 수정
    @GetMapping("/report")
    public String getReportPage(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        log.info("공복혈당 리포트 페이지.....");

        // 최근 7일의 데이터만 가져오기
        LocalDate sevenDaysAgo = LocalDate.now().minusDays(6);
        List<FastingDTO> fastingDataList = fastingService.findByUserid(userDetails.getUsername())
                .stream()
                .filter(data -> data.getRegistDate().isAfter(sevenDaysAgo))
                .collect(Collectors.toList());

        log.info("최근 7일 데이터" + fastingDataList);

        // emptyData
        List<Integer> emptyDataList = fastingDataList.stream()
                .map(FastingDTO::getEmptyData)
                .collect(Collectors.toList());

        log.info("emptyDataList 는" + emptyDataList);

        // 혈당 관리 메세지
        // 가장 최근 데이터를 오늘로 가정
        FastingDTO todayData = fastingDataList.stream()
                .filter(data -> data.getRegistDate().isAfter(LocalDate.now().minusDays(1)))
                .findFirst()
                .orElse(null);

        log.info("오늘 날짜 : " + todayData);

        // 어제 날짜를 계산
        LocalDate yesterday = LocalDate.now().minusDays(1);

        // 어제 데이터를 찾음
        FastingDTO yesterdayData = fastingDataList.stream()
                .filter(data -> data.getRegistDate().isEqual(yesterday))
                .findFirst()
                .orElse(null);

        log.info("어제 날짜 : " + yesterdayData);

        // 오늘과 어제의 혈당 수치를 가져오기
        int todayValue = (todayData != null) ? todayData.getEmptyData() : 0; // 오늘의 수치
        int yesterdayValue = (yesterdayData != null) ? yesterdayData.getEmptyData() : 0; // 어제의 수치

        // 메시지 설정
//        String message = (todayValue > yesterdayValue) ?
//                "오늘은 혈당 관리에 신경써주세요" : "혈당을 잘 관리하셨어요! 훌륭합니다";

        // EmptyData에 대한 메시지 설정
        String emptyDataMessage = (todayValue > yesterdayValue) ?
                "오늘은 혈당이 어제보다 높습니다. 혈당 관리에 신경써주세요.😂":
                "오늘은 어제보다 혈당이 낮습니다. 혈당을 잘 관리하셨어요! 훌륭합니다.😃";
;

        // 메시지를 로그에 출력
        log.info("혈당 관리 메세지 : " + emptyDataMessage);
        // log.info("message는 : " + message);

        // Thymeleaf에서 사용할 수 있도록 데이터를 모델에 추가
        // model.addAttribute("message", message);
        model.addAttribute("emptyDataMessage", emptyDataMessage); // (추가) EmptyData 메시지를 모델에 추가
        model.addAttribute("todayData", todayData);


        // registDate
        List<LocalDate> registDateList = fastingDataList.stream()
                .map(FastingDTO::getRegistDate)
                .sorted() // 날짜를 오름차순으로 정렬
                .collect(Collectors.toList());
        log.info("registDateList 는" + registDateList);

        // emptyData의 평균 계산
        int average = (int) fastingDataList.stream()
                .mapToInt(FastingDTO::getEmptyData)
                .average()
                .orElse(0.0);
        log.info("average 는" + average);

        // averageData 배열 생성
        List<Integer> averageData = Collections.nCopies(fastingDataList.size(), (int) average);

        // Thymeleaf에서 사용할 수 있도록 데이터를 모델에 추가
        model.addAttribute("fastingDataList", fastingDataList);
        model.addAttribute("emptyDataList", emptyDataList);
        model.addAttribute("registDateList", registDateList);
        model.addAttribute("average", average);
        model.addAttribute("averageData", averageData);

        // templates 폴더에 있는 report.html을 렌더링
        return "/fasting/report";
    }

}

