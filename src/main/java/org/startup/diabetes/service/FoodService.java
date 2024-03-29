package org.startup.diabetes.service;

import org.startup.diabetes.dto.FoodDTO;
import java.util.List;

public interface FoodService {

    Long register(FoodDTO foodDTO);

    List<FoodDTO> findAll();

    public List<FoodDTO> getAllFoods();
}
