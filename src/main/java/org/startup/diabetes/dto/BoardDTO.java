package org.startup.diabetes.dto;

import lombok.*;
import org.startup.diabetes.domain.Board;
import org.startup.diabetes.domain.Food;
import org.startup.diabetes.domain.Member;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private Long bno;
    private LocalDate registDate;
    private String time;
    private int afterBlood;
    private Member member;
    private Food food;

    public static BoardDTO toBoardDTO(Board board){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBno(board.getBno());
        boardDTO.setRegistDate(board.getRegistDate());
        boardDTO.setTime(board.getTime());
        boardDTO.setAfterBlood(board.getAfterBlood());
        boardDTO.setFood(board.getFood());
        return boardDTO;
    }
}

