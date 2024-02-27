package org.startup.diabetes.dto;

import lombok.*;

// DTO(Data Transfer Object), VO, Bean
// Entity
@Builder
@Getter
@Setter
@ToString //필드값
@NoArgsConstructor //기본생성
@AllArgsConstructor //모든 필드를 매개변수로 하는 생성자
public class FastingDTO {

    // html name, 필드값 동일하다면
    // setter 메서드로 DTO에 담아줌
    private Long emptyId;
    private int emptyData;
}