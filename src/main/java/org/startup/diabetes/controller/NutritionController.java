package org.startup.diabetes.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.startup.diabetes.domain.Food;
import org.startup.diabetes.dto.BoardDTO;
import org.startup.diabetes.dto.FastingDTO;
import org.startup.diabetes.dto.FoodDTO;
import org.startup.diabetes.service.BoardService;
import org.startup.diabetes.service.FastingService;
import org.startup.diabetes.service.FoodService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Controller
@RequiredArgsConstructor //컨트롤러에서 서비스클래스 호출해야해서 써줌
public class NutritionController {
    private final BoardService boardService;
    private final FoodService foodService;

    @GetMapping("/info")
    public String findAll(Model model) {
        // 게시글 정보 가져오기
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardDTOList", boardDTOList);

        // 음식 정보 가져오기

        List<FoodDTO> foodDTOList = foodService.findAll();
        model.addAttribute("foodList", foodDTOList);

        // 식후 혈당 정보 가져오기 및 정렬
        List<Integer> afterBloodList = new ArrayList<>();
        for (BoardDTO boardDTO : boardDTOList) {
            afterBloodList.add(boardDTO.getAfterBlood());
        }
        afterBloodList.sort(Comparator.naturalOrder());
        model.addAttribute("afterBloodList", afterBloodList);

        return "/board/info";
    }
}
