package org.startup.diabetes.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.startup.diabetes.dto.BoardDTO;
import org.startup.diabetes.dto.FastingDTO;
import org.startup.diabetes.repository.BoardRepository;
import org.startup.diabetes.service.BoardService;
import org.startup.diabetes.service.FastingService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Log4j2
@RequiredArgsConstructor
//@RequestMapping("/highlight")
public class HighlightController {

    private final FastingService fastingService;
    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @GetMapping("/highlight")
    public String highlightGET(Model model, @AuthenticationPrincipal UserDetails userDetails) {

        Map<String, List<BoardDTO>> dataMap = new HashMap<>();

        log.info("혈당정보 하이라이트 페이지.....");

        // 최근 7일의 데이터만 가져오기
        LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);
        List<FastingDTO> fastingDataList = fastingService.findByUserid(userDetails.getUsername())
                .stream()
                .filter(data -> data.getRegistDate().isAfter(sevenDaysAgo))
                .sorted(Comparator.comparing(FastingDTO::getRegistDate)) // registDate로 정렬
                .collect(Collectors.toList());
        log.info("fastingDataList 최근 7일 데이터" + fastingDataList);

        // fastingDataList가 비어있지 않다면
        if (!fastingDataList.isEmpty()) {
            // 최소 날짜와 최대 날짜 추출
            LocalDate startDate = fastingDataList.stream()
                    .map(FastingDTO::getRegistDate)
                    .min(LocalDate::compareTo)
                    .orElse(null);

            LocalDate endDate = fastingDataList.stream()
                    .map(FastingDTO::getRegistDate)
                    .max(LocalDate::compareTo)
                    .orElse(null);
            log.info("startDate 시작 날짜: " + startDate);
            log.info("endDate 끝 날짜: " + endDate);

        // fastingDataList에서 registDate의 day만 추출
        // 배열로 저장하고 이전 날짜부터 순서대로 정렬
        List<Integer> dayList = fastingDataList.stream()
                .sorted(Comparator.comparing(data -> data.getRegistDate()))
                .map(data -> data.getRegistDate().getDayOfMonth())
                .collect(Collectors.toList());

        log.info("dayList 날짜 정렬 : " + dayList);

        // fastingDataList에서 registDate를 기준으로 정렬하고 이전 날짜부터 emptyData를 배열로 저장
        List<Integer> emptyDataList = fastingDataList.stream()
                .sorted(Comparator.comparing(FastingDTO::getRegistDate))
                .map(FastingDTO::getEmptyData)
                .collect(Collectors.toList());

        log.info("emptyDataList 공복 혈당 정렬 : " + emptyDataList);

        // emptyDataList에서 평균값 계산
        int averageEmptyData = (int)emptyDataList.stream()
                .mapToInt(Integer::intValue) // 이 부분을 수정
                .average()
                .orElse(0);

        log.info("averageEmptyData 평균 공복 혈당: " + averageEmptyData);

        // emptyDataList에서 제일 높은 값
        int maxEmptyData = emptyDataList.stream()
                .max(Comparator.naturalOrder())
                .orElse(0);

        log.info("maxEmptyData 제일 높은 공복 혈당: " + maxEmptyData);

        // emptyDataList에서 제일 낮은 값
        int minEmptyData = emptyDataList.stream()
                .min(Comparator.naturalOrder())
                .orElse(0);

        log.info("minEmptyData 제일 낮은 공복 혈당: " + minEmptyData);



//            List<FastingDTO> fastingDataList = fastingService.findByUserid(userDetails.getUsername())
//                    .stream()
//                    .filter(data -> data.getRegistDate().isAfter(sevenDaysAgo))
//                    .sorted(Comparator.comparing(FastingDTO::getRegistDate)) // registDate로 정렬
//                    .collect(Collectors.toList());
        //BoardService
        // 아침 데이터 가져오기
            List<BoardDTO> morningData = boardRepository.findByTime("아침")
                    .stream()
                    .map(BoardDTO::toBoardDTO)
                    .sorted(Comparator.comparing(BoardDTO::getRegistDate)) // registDate로 정렬
                    .collect(Collectors.toList());
            dataMap.put("아침", morningData);
        log.info("morningData" + morningData);

        // morningData에서 afterBlood만 배열로 정리
        List<Integer> morningDataList = morningData.stream()
                .map(BoardDTO::getAfterBlood)
                .collect(Collectors.toList());
        log.info("morningDataList 아침 식후 혈당은 : " + morningDataList);

        // 평균 아침 식후 혈당
        int averageMorningData = (int)morningDataList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        log.info("평균 아침 식후 혈당: " + averageMorningData);

        // 최고 아침 식후 혈당
        int maxMorningData = morningDataList.stream()
                .max(Comparator.naturalOrder())
                .orElse(0);

        log.info("최고 아침 식후 혈당: " + maxMorningData);

        // 최저 아침 식후 혈당
        int minMorningData = morningDataList.stream()
                .min(Comparator.naturalOrder())
                .orElse(0);

        log.info("최저 아침 식후 혈당: " + minMorningData);

        // 점심 데이터 가져오기
            List<BoardDTO> afternoonData = boardRepository.findByTime("점심")
                    .stream()
                    .map(BoardDTO::toBoardDTO)
                    .sorted(Comparator.comparing(BoardDTO::getRegistDate)) // registDate로 정렬
                    .collect(Collectors.toList());
            dataMap.put("점심",afternoonData);
            log.info("afternoonData" + afternoonData);

        // afternoonData에서 afterBlood만 배열로 정리
        List<Integer> afternoonDataList = afternoonData.stream()
                .map(BoardDTO::getAfterBlood)
                .collect(Collectors.toList());

        log.info("afternoonDataList 점심 식후 혈당 : " + afternoonDataList);

        // 평균 점심 식후혈당
        int averageAfternoon = (int)afternoonDataList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        log.info("평균 아침 식후 혈당: " + averageAfternoon);

        // 최고 점심 식후혈당
        int maxAfternoonData = afternoonDataList.stream()
                .max(Comparator.naturalOrder())
                .orElse(0);

        log.info("최고 아침 식후 혈당: " + maxAfternoonData);

        // 최저 점심 식후 혈당
        int minAfternoonData = afternoonDataList.stream()
                .min(Comparator.naturalOrder())
                .orElse(0);

        log.info("최저 아침 식후 혈당: " + minAfternoonData);

        // 저녁 데이터 가져오기
        List<BoardDTO> eveningData = boardRepository.findByTime("저녁")
                .stream()
                .map(BoardDTO::toBoardDTO)
                .sorted(Comparator.comparing(BoardDTO::getRegistDate)) // registDate로 정렬
                .collect(Collectors.toList());
        dataMap.put("저녁", eveningData);

        log.info("eveningData" + eveningData);

        // afternoonData에서 afterBlood만 배열로 정리
        List<Integer> eveningDataList = eveningData.stream()
                .map(BoardDTO::getAfterBlood)
                .collect(Collectors.toList());

        log.info("eveningDataList 저녁 식후 혈당 : " + eveningDataList);

        // 평균 아침 식후 혈당
        int averageEvening = (int)eveningDataList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        log.info("평균 저녁 식후 혈당: " + averageEvening);

        // 최고 아침 식후 혈당
        int maxEveningData = eveningDataList.stream()
                .max(Comparator.naturalOrder())
                .orElse(0);

        log.info("최고 저녁 식후 혈당: " + maxEveningData);

        // 최저 아침 식후 혈당
        int minEveningData = eveningDataList.stream()
                .min(Comparator.naturalOrder())
                .orElse(0);

        log.info("최저 저녁 식후 혈당: " + minEveningData);

        // Thymeleaf에서 사용할 수 있도록 데이터를 모델에 추가
            model.addAttribute("dataMap", dataMap);
        model.addAttribute("fastingDataList", fastingDataList);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("dayList", dayList);
        model.addAttribute("emptyDataList", emptyDataList);
        model.addAttribute("averageEmptyData", averageEmptyData);
        model.addAttribute("maxEmptyData", maxEmptyData);
        model.addAttribute("minEmptyData", minEmptyData);
        model.addAttribute("morningData", morningData);
        model.addAttribute("afternoonData", afternoonData);
        model.addAttribute("eveningData", eveningData);
        model.addAttribute("averageMorningData", averageMorningData);
        model.addAttribute("maxMorningData", maxMorningData);
        model.addAttribute("minMorningData", minMorningData);
        model.addAttribute("averageAfternoon", averageAfternoon);
        model.addAttribute("maxAfternoonData", maxAfternoonData);
        model.addAttribute("minAfternoonData", minAfternoonData);
        model.addAttribute("averageEvening", averageEvening);
        model.addAttribute("maxEveningData", maxEveningData);
        model.addAttribute("minEveningData", minEveningData);
        }
        return "/fasting/highlight";  // Return the view name
    }
}
