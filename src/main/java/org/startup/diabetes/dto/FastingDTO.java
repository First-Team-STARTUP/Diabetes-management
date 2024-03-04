package org.startup.diabetes.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

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
    private Long bno;

    @NotNull
    //@Size(min =3, max =100)
    private Integer emptyData;

    //private LocalDateTime regDate;
    //private LocalDateTime modDate;
}