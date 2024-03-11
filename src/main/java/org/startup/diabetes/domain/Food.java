package org.startup.diabetes.domain;

import jakarta.persistence.*;
import lombok.*;
import org.startup.diabetes.dto.FastingDTO;
import org.startup.diabetes.dto.FoodDTO;

@Builder
@AllArgsConstructor //Builder랑 세트
@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Food") //테이블 이름
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto
    private Long bno;

    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "plusBlood")
    private Integer plusBlood;

    @Column(name = "calorie")
    private Integer calorie; //열량

    @Column(name = "protein")
    private Integer protein; //단백질

    @Column(name = "carbohydrate")
    private Integer carbohydrate; //탄수화물

    @Column(name = "sugar")
    private Integer sugar; //당류

    @Column(name = "natrium")
    private Integer natrium; //나트륨

    @Column(name = "images")
    private String images; //이미지

    //매핑
    //@OneToOne(mappedBy = "food")
    //private Board board;
}
