//package org.startup.diabetes.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//import org.startup.diabetes.dto.BoardDTO;
//import org.startup.diabetes.service.BoardService;
//
//import java.time.LocalDate;
//import java.util.HashMap;
//import java.util.List;
//
//@RequiredArgsConstructor
//@RestController
//public class BoardRestController {
//
//    private final BoardService boardService;
//
//    @RequestMapping(value = "/data", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<?> getDataByDate(@AuthenticationPrincipal UserDetails userDetails,
//                                           @RequestParam(name = "selectedDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate selectedDate) {
//
//        // 현재 사용자의 해당 날짜에 해당하는 데이터 가져오기
//        String userid = userDetails.getUsername();
//        List<BoardDTO> boardDTOList = boardService.getBoardByDate(selectedDate, userid);
//
//        // 데이터를 HashMap에 담기
//        HashMap<String, Object> response = new HashMap<>();
//        response.put("boardDTOList", boardDTOList);
//
//        // ResponseEntity로 JSON 형태로 데이터 반환
//        return ResponseEntity.ok().body(response);
//    }
//}
