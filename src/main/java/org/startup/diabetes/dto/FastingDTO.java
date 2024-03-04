package org.startup.diabetes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

// DTO(Data Transfer Object), VO, Bean
// Entity
@Builder
@Data
@ToString //필드값
@NoArgsConstructor //기본생성
@AllArgsConstructor //모든 필드를 매개변수로 하는 생성자
public class FastingDTO {

    // html name, 필드값 동일하다면
    // setter 메서드로 DTO에 담아줌
    private Long bno;

    @NotBlank(message = "입력값은 50~900입니다.")
    @Size(min=50, max=900)
    //@Size(min =3, max =100)
    private Integer emptyData;

    @NotBlank(message = "날짜는 중복해서 입력할 수 없습니다.")
    private LocalDate registDate;

}