package org.startup.diabetes.service;

import org.startup.diabetes.dto.FastingDTO;
import org.startup.diabetes.dto.FoodDTO;

public interface FoodService {

    Long register(FoodDTO foodDTO);
}
