package org.startup.diabetes.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.startup.diabetes.dto.BoardDTO;

import java.time.LocalDate;

@Entity  //클래스,서비스,엔티티 각 패키지에맞게 어노테이션붙여주자..ㅋ
@Setter
@Getter
@Table(name="board") //테이블어노테이션은  디비에 실제 이 클래스정의대로 테이블생성되는데 그렇게만들어주는역할.
//실제 테이블 디비에만들어지면 테이블이름이됨.ㅋ
public class BoardEntity {

    //자, 테이블정의시 pk 기본키가있지?
    @Id //어노테이션을써줌
    @Column(name = "bno")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mysql에서의 오토인크리먼트,ㅋ
    private Long bno;

//    @Column(length = 20,nullable = false) //그다음 일반컬럼, + 유니크 제약조건추가
//    private String Time;

    @Column(name = "registDate", nullable = false)
    @DateTimeFormat(pattern = "MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd", timezone = "Asia/Seoul")
    private LocalDate registDate; //등록하는 날짜

    @Column(name = "time", nullable = false)
    private String time;

    @Column(name = "food", nullable = false)
    private String food;

    //OneToOne
    //@JoinColumn(name="bno")
    //@OneToOne
    //private Food Food; //Food 엔티티 갖고오는

    @Column(name="afterBlood", nullable = false)
    private int afterBlood;


    public static BoardEntity toSaveEntity(BoardDTO boardDTO) {

        //dto담긴객체를 엔티티로 옮기자.
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBno(boardDTO.getBno());
        boardEntity.setRegistDate(boardDTO.getRegistDate());
        boardEntity.setTime(boardDTO.getTime());
        boardEntity.setFood(boardDTO.getFood());
        boardEntity.setAfterBlood(boardDTO.getAfterBlood());
        return boardEntity;
    }
}
