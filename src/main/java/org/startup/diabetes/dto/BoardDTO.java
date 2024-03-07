package org.startup.diabetes.dto;

import lombok.*;
import org.startup.diabetes.domain.Board;
import org.startup.diabetes.domain.Fasting;
import org.startup.diabetes.domain.Member;

import java.time.LocalDate;

@Getter
@Setter  //어노테이션붙여주면 각각 필드들에대해
@ToString
@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 필드를 매개변수로하는 생성자
//뭐 데이터 주고받을때 파라미터가 여러가지있지.. 다 따로따로 보내기엔 그래서..ㅋ 양이많을땐 비닐봉지 잠깐쓰자..ㅋ
public class BoardDTO {

    private Long bno;  //id pk,
    private LocalDate registDate; //등록하는 날짜
    private String time;
    private String food;
    private int afterBlood;
    private Member member;
    private Fasting fasting;

    //게시글 작성시간, 수정시간
//    private LocalDateTime CreatedTime;
//    private LocalDateTime UpdatedTime;

    //그리고 private로 접근제한자두고,,
    //그리고 생성자, 게터세터 하는게 ㅋ 필드값 가져오기위해 private라.. -> lombok!(라이브러리)으로.ㅋ대처

    // ----DTO -> entity였다면,
    // ↓이번엔 반대
    public static BoardDTO toBoardDTO(Board board){
        BoardDTO boardDTO=new BoardDTO();
        boardDTO.setBno(board.getBno());
        boardDTO.setRegistDate(board.getRegistDate());
        boardDTO.setTime(board.getTime());
        boardDTO.setFood(board.getFood());
        boardDTO.setAfterBlood(board.getAfterBlood());
        boardDTO.setMember(boardDTO.getMember());
        return boardDTO;
    }
}