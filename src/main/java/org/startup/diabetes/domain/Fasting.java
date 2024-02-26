package org.startup.diabetes.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fasting_table") //테이블 이름
public class Fasting {

    @Id //pk지정 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long emptyId;

    @Column(length = 20, nullable = false) //크기 20, not null
    private int emptyData;

    @Column
    private LocalDateTime dateTime;
}
