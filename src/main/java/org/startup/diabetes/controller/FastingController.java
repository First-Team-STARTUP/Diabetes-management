package org.startup.diabetes.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.startup.diabetes.dto.FastingDTO;
import org.startup.diabetes.dto.PageRequestDTO;
import org.startup.diabetes.dto.PageResponseDTO;
import org.startup.diabetes.service.FastingService;

import java.io.IOException;


@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/fasting")
public class FastingController {

    private final FastingService fastingService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){

        PageResponseDTO<FastingDTO> responseDTO = fastingService.list(pageRequestDTO);
        log.info(responseDTO);
        model.addAttribute("responseDTO", responseDTO);
    }

}
