package org.startup.diabetes.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.startup.diabetes.domain.GraphVO;
import org.startup.diabetes.service.GraphService;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@Log4j2
public class GraphController {

    @Autowired
    private GraphService graphService;

    @RequestMapping("/countFasting.do")
    public @ResponseBody List<GraphVO> countFasting(Model model, GraphVO vo) throws  Exception {
        List<GraphVO> fasting = graphService.countFasting(vo);
        log.info(graphService.countFasting(vo));
        model.addAttribute("fasting", fasting);
        return fasting;
    }
}
