package org.startup.diabetes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.startup.diabetes.dto.BoardDTO;
import org.startup.diabetes.service.BoardService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")  //이렇게하면 이하의 주소를 각각의 메소드중 일치하는
//매핑값이 일치하는 메소드가 호출된다.!이런구조임..ㅋ
//아~ @Request어노테이션은 진짜 필요한걸 단축한 단축키느낌.ㅋ ex) /board공통되니, 알아서 생략하게끔

public class BoardController {
    private final BoardService boardService;

    @GetMapping("/save")  //역시 만들어줘야지 ㅋ
    public String saveForm() {
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) {
        System.out.println("boardDTO=" + boardDTO);
        boardService.save(boardDTO);
        return "index";
    }

    //그래서 이 메소드가 호출되면, save.html 리턴을 주게되고, 어디로??
    //get으로보냈을때와, post로 보냈을때 다르게 메소드해줘야하는군..매핑때문에..
    //비슷하네 ㅋ ㄹ입력한 값을 컨트롤러로 전달해줄땐, 리퀘스트파람 @RequestParam,ㅋ
    @GetMapping("/")
    public String findAll(Model model) {//컨트롤러에선,  일단 데이터를 db로부터 가져와야하니 모델객체사용!
        //그리고 여러개를 가져아야하니.. 리스트!타입으로, <boardDTO객체가 담겨있는 리스트!>
        List<BoardDTO> boardDTOList = boardService.findAll(); //담고,  boardServiceㅇ에있는걸 리턴받아,
        //가져온데이터를 모델객체에 담자.   모델에담아서 List q뷰로 넘어가게됨!
        model.addAttribute("boardList", boardDTOList);
        //그리고 어디로? 리스트뷰로!가자
        return "list";
        //즉 DB에서 전체 게시글 데이터를 가져와  뷰에서보여준다.
        //서비스에만들어줘야지?

    }
}
