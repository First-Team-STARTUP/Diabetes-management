package org.startup.diabetes.dto;

import lombok.*;
import org.startup.diabetes.domain.Food;

import java.awt.*;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {

    // html name, 필드값 동일하다면
    // setter 메서드로 DTO에 담아줌
    private Long bno;

    private String title;

    private Integer plusBlood;

    private Integer calorie; //열량

    private Integer protein; //단백질

    private Integer carbohydrate; //탄수화물

    private Integer sugar; //당류

    private Integer natrium; //나트륨

    // 엔티티 -> DTO
    public static FoodDTO tofoodDTO(Food food){
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setBno(food.getBno());
        foodDTO.setTitle(food.getTitle());
        foodDTO.setPlusBlood(food.getPlusBlood());
        foodDTO.setCalorie(food.getCalorie());
        foodDTO.setProtein(food.getProtein());
        foodDTO.setCarbohydrate(food.getCarbohydrate());
        foodDTO.setSugar(food.getSugar());
        foodDTO.setNatrium(food.getNatrium());
        return foodDTO;
    }
}
