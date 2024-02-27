package org.startup.diabetes.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


//@Data
//@Builder
//@AllArgsConstructor
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "fasting_table") //테이블 이름
public class Fasting extends BaseEntity {

    @Id //pk지정 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long emptyId;

    @Column(length = 20, nullable = false) //크기 20, not null
    private int emptyData;

    public void change(int emptyData){
        this.emptyData = emptyData;

    }

}
