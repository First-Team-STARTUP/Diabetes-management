package org.startup.diabetes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.startup.diabetes.domain.Food;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {

    private Long bno;
    private String title;
    private Integer plusBlood;
    private Integer calorie;
    private Integer protein;
    private Integer carbohydrate;
    private Integer sugar;
    private Integer natrium;


    // 엔티티 -> DTO
    public static FoodDTO toFoodDTO(Food food){
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
