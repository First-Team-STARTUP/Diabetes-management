package org.startup.diabetes.service;

import org.startup.diabetes.domain.Food;
import org.startup.diabetes.dto.FastingDTO;
import org.startup.diabetes.dto.FoodDTO;

import java.util.List;

public interface FoodService {
    Long register(FoodDTO foodDTO);

    public List<FoodDTO> getAllFoods();
}
