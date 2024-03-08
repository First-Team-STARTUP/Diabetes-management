//package org.startup.diabetes.dto;
//
//import jakarta.validation.constraints.NotNull;
//import lombok.*;
//import org.hibernate.validator.constraints.Range;
//import org.startup.diabetes.domain.Board;
//import org.startup.diabetes.domain.Member;
//
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//public class NutriDTO {
//    private Long bno;
//    @NotNull(message = "공복혈당은 필수값입니다.")
//    @Range(min = 50, max = 899, message = "공복혈당은 50 이상, 899 미만이어야 합니다.")
//    //@Size(min =3, max =100)
//    private Integer emptyData;
//
//    private Member member;
//
//    private Board board;
//}
