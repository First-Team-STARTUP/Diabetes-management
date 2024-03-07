package org.startup.diabetes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.startup.diabetes.dto.BoardDTO;
import org.startup.diabetes.dto.FastingDTO;
import org.startup.diabetes.service.BoardService;
import org.startup.diabetes.service.FastingService;

import java.util.List;

@Controller
@RequiredArgsConstructor //컨트롤러에서 서비스클래스 호출해야해서 써줌
public class NutritionController {
    private final BoardService boardService;
    //private final FastingService fastingService; //생성자주입방식-의존성주입받을수있음
    @GetMapping("/info")
    public String info() {
        return "/board/info";
    }
//    @PostMapping("/info")
//    public String infoout(@ModelAttribute BoardDTO boardDTO, FastingDTO fastingDTO) {
//        System.out.println("BoardDTO:"+boardDTO);
//        System.out.println("FastingDTO:"+fastingDTO);
//        boardService.save(boardDTO);
//        return "/board/info";
//    }

    //db에서 게시글(현재로선전체, 난식후만필요) 데이터를 가져와서info에 보여준다.
    public String findAll(Model model) {//컨트롤러에선,  일단 데이터를 db로부터 가져와야하니 모델객체사용!
        //그리고 여러개를 가져아야하니.. 리스트!타입으로, <boardDTO객체가 담겨있는 리스트!>
        List<BoardDTO> boardDTOList = boardService.findAll(); //담고,  boardServiceㅇ에있는걸 리턴받아,
        //가져온데이터를 모델객체에 담자.   모델에담아서 List q뷰로 넘어가게됨!
        model.addAttribute("startup", boardDTOList);
        //그리고 어디로? 리스트뷰로!가자  "boardList2: 모델임" 담아서 entity->dto로
        return "/board/info";
        //즉 DB에서 전체 게시글 데이터를 가져와  뷰에서보여준다.
        //서비스에만들어줘야지?

    }


}
