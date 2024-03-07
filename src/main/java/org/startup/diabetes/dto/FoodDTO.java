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

    public static FoodDTO tofoodDTO(Food food) {
        return FoodDTO.builder()
                .bno(food.getBno())
                .title(food.getTitle())
                .plusBlood(food.getPlusBlood())
                .calorie(food.getCalorie())
                .protein(food.getProtein())
                .carbohydrate(food.getCarbohydrate())
                .sugar(food.getSugar())
                .natrium(food.getNatrium())
                .build();
    }

}
