package org.startup.diabetes.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;


//@Data
//@Builder
//@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "fasting") //테이블 이름
public class Fasting extends BaseEntity {

    @Id //pk지정 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long bno;

    @JoinColumn(name = "member_id")
    @ManyToOne
    private Member member;

    @Column(length = 20, nullable = false) //크기 20, not null
    private Integer emptyData;

    @Column(name = "registDate", nullable = false)
    @DateTimeFormat(pattern = "MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd", timezone = "Asia/Seoul")
    private LocalDate registDate;

    public void change(int emptyData){
        this.emptyData = emptyData;
    }

}
