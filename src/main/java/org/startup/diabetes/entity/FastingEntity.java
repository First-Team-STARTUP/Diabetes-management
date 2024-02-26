package org.startup.diabetes.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

//DB테이블 역할을 하는 클래스 필수적
@Entity
@Getter
@Setter
@Table(name = "fasting_table") //테이블 이름
public class FastingEntity extends BaseEntity{

    @Id //pk 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long emptyId;

    @Column(length = 20, nullable = false) //크기 20, not null
    private int emptyData;

    @Column(unique = true)
    private LocalDateTime datetime;
}
