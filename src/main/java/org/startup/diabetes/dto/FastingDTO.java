package org.startup.diabetes.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.startup.diabetes.domain.Fasting;

import java.time.LocalDate;

// DTO(Data Transfer Object), VO, Bean
// Entity
@Builder
@Data
//@Getter
//@Setter
@ToString //필드값
@NoArgsConstructor //기본생성
@AllArgsConstructor //모든 필드를 매개변수로 하는 생성자
public class FastingDTO {

    // html name, 필드값 동일하다면
    // setter 메서드로 DTO에 담아줌
    private Long bno;

    @NotNull(message = "공복혈당은 필수값입니다.")
    @Range(min = 50, max = 899, message = "공복혈당은 50 이상, 899 미만이어야 합니다.")
    private Integer emptyData;

    @NotNull(message = "날짜입력은 필수값입니다.")
    @Column(name = "registDate")
    @DateTimeFormat(pattern = "MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd", timezone = "Asia/Seoul")
    private LocalDate registDate;

    // 엔티티 -> DTO
    public static FastingDTO tofastingDTO(Fasting fasting){
        FastingDTO fastingDTO = new FastingDTO();
        fastingDTO.setBno(fasting.getBno());
        fastingDTO.setEmptyData(fasting.getEmptyData());
        fastingDTO.setRegistDate(fasting.getRegistDate());
        return fastingDTO;
    }

}