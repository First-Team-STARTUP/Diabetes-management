package org.startup.diabetes.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.startup.diabetes.dto.BoardDTO;
import org.startup.diabetes.dto.FoodDTO;
import org.startup.diabetes.repository.BoardRepository;
import org.startup.diabetes.service.BoardService;
import org.startup.diabetes.service.FoodService;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")  //이렇게하면 이하의 주소를 각각의 메소드중 일치하는
//매핑값이 일치하는 메소드가 호출된다.!이런구조임..ㅋ
//아~ @Request어노테이션은 진짜 필요한걸 단축한 단축키느낌.ㅋ ex) /board공통되니, 알아서 생략하게끔

public class BoardController {


    private final BoardService boardService;
    private final FoodService foodService;
    private final BoardRepository boardRepository;


    @GetMapping("/save")
    public String saveForm(@AuthenticationPrincipal UserDetails userDetails,
                           @RequestParam(name = "selectedDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate selectedDate,
                           Model model) {

        // 현재 날짜 설정
        LocalDate currentDate = (selectedDate == null) ? LocalDate.now() : selectedDate;

        // 선택된 날짜를 모델에 추가
        model.addAttribute("registDate", currentDate);

        // 현재 사용자의 해당 날짜에 해당하는 보드 그룹 가져오기
        List<BoardDTO> boardDTOList = boardService.getBoardGroupsByDate(userDetails.getUsername(), currentDate);

        // 외래키로 지정된 Food 엔티티의 제목 가져오기
        List<FoodDTO> foodList = foodService.getAllFoods();

        // 모델에 추가하여 뷰에 전달
        model.addAttribute("boardList", boardDTOList);
        model.addAttribute("foodList", foodList);

        // 오늘 날짜를 기본값으로 설정하여 모델에 추가
        return "/board/save";
    }


    @GetMapping("/getDataByDate")
    @ResponseBody
    public ResponseEntity<List<BoardDTO>> getDataByDate(@RequestParam(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                                        @AuthenticationPrincipal UserDetails userDetails) {
        List<BoardDTO> boardDTOList = boardService.findBoardByRegistDate(date, userDetails);
        return ResponseEntity.ok(boardDTOList);
    }


    @PostMapping("/save")
    public String processForm(@AuthenticationPrincipal UserDetails userDetails,
                              @Valid BoardDTO boardDTO,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            // 유효성 검사 오류가 있을 경우 처리
            log.info("오류가 있습니다: " + bindingResult.getAllErrors());
            return "/board/save"; // 오류 페이지로 리다이렉트 또는 다시 입력 폼을 보여줄 수 있음
        }
        log.info(boardDTO);
        try {
            // 여기에 추가적인 로그를 삽입
            log.info("저장 전 boardDTO의 member 아이디: " + boardDTO.getMember());
            Long bno = boardService.saveBoard(boardDTO, userDetails);

            // 여기에 추가적인 로그를 삽입
            log.info("저장된 board의 Bno: " + bno);

            redirectAttributes.addFlashAttribute("result", bno);
            log.info("저장 완료 !");
        } catch (Exception e) {
            log.error("저장 중 오류가 발생했습니다: " + e.getMessage());
            // 예외 처리 로직 추가
            return "/board/save"; // 오류 페이지로 리다이렉트 또는 다시 입력 폼을 보여줄 수 있음
        }

        // 유효성 검사 이후에도 boardList를 다시 가져오기
        return "redirect:/board/save";
    }



//
//    그래서 이 메소드가 호출되면, save.html 리턴을 주게되고, 어디로??
//    get으로보냈을때와, post로 보냈을때 다르게 메소드해줘야하는군..매핑때문에..
//    비슷하네 ㅋ ㄹ입력한 값을 컨트롤러로 전달해줄땐, 리퀘스트파람 @RequestParam,ㅋ
    @GetMapping("/")
    public String findAll(Model model) {//컨트롤러에선,  일단 데이터를 db로부터 가져와야하니 모델객체사용!
        //그리고 여러개를 가져아야하니.. 리스트!타입으로, <boardDTO객체가 담겨있는 리스트!>
        List<BoardDTO> boardDTOList = boardService.findAll(); //담고,  boardServiceㅇ에있는걸 리턴받아,
        //가져온데이터를 모델객체에 담자.   모델에담아서 List q뷰로 넘어가게됨!
        model.addAttribute("boardList", boardDTOList);
        //그리고 어디로? 리스트뷰로!가자
        return "/board/save";
        //즉 DB에서 전체 게시글 데이터를 가져와  뷰에서보여준다.
        //서비스에만들어줘야지?

    }
}
