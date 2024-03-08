package org.startup.diabetes.dto;

import lombok.*;
import org.startup.diabetes.domain.Board;
import org.startup.diabetes.domain.Food;
import org.startup.diabetes.domain.Member;

import java.time.LocalDate;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private Long bno;
    private Member member;
    private LocalDate registDate;
    private String time;
    private int afterBlood;
    private Food food;

    public static BoardDTO toBoardDTO(Board board){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBno(board.getBno());
        boardDTO.setMember(board.getMember());
        boardDTO.setRegistDate(board.getRegistDate());
        boardDTO.setTime(board.getTime());
        boardDTO.setAfterBlood(board.getAfterBlood());
        boardDTO.setFood(board.getFood());
        return boardDTO;
    }
}

