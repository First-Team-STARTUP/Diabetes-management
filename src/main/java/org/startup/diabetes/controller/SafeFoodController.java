package org.startup.diabetes.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.startup.diabetes.dto.FastingDTO;
import org.startup.diabetes.dto.FoodDTO;
import org.startup.diabetes.service.FastingService;
import org.startup.diabetes.service.FoodService;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Controller
@RequiredArgsConstructor
public class SafeFoodController {

    private final FoodService foodService;
    private final FastingService fastingService;
    @GetMapping("/safefood")
    public String safeFoodGET(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        log.info("safe food page..............");

        // 음식 목록 가져오기
        List<FoodDTO> foodDataList = foodService.getAllFoods();

        // 최근 데이터만 가져오기
        LocalDate oneDayAgo = LocalDate.now().minusDays(1);
        List<FastingDTO> safeFoodDataList = fastingService.findByUserid(userDetails.getUsername())
                .stream()
                .filter(data -> data.getRegistDate().isAfter(oneDayAgo))
                .sorted(Comparator.comparing(FastingDTO::getRegistDate)) // registDate로 정렬
                .collect(Collectors.toList());

        log.info("fastingDataList 최근 1일 데이터" + safeFoodDataList);

        // 모델에 음식 목록 추가
        model.addAttribute("foodDataList", foodDataList);
        log.info("foodDataList 는 :" + foodDataList);

        // 모델에 추가할 속성 (title 및 plusBlood) 가져오기
        String title = ""; // 여기에 적절한 값 설정
        Integer plusBlood = 0; // 여기에 적절한 값 설정

        // Thymeleaf에서 사용할 수 있도록 데이터를 모델에 추가
        model.addAttribute("title", title);
        model.addAttribute("plusBlood", plusBlood);
        model.addAttribute("safeFoodDataList", safeFoodDataList);

        return "fasting/safeFood"; // 뷰의 경로를 반환
    }
}

