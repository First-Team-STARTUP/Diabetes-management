package org.startup.diabetes.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.startup.diabetes.domain.Food;
import org.startup.diabetes.dto.FoodDTO;
import org.startup.diabetes.repository.BoardRepository;
import org.startup.diabetes.repository.FoodRepository;


@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class FoodServiceImple implements FoodService {

    private final FoodRepository foodRepository;
    private final BoardRepository boardRepository;

    @Override
    public Long register(FoodDTO foodDTO) {

        //builder sql문
        Food food = Food.builder()
        .title(foodDTO.getTitle())
        .plusBlood(foodDTO.getPlusBlood())
        .calorie(foodDTO.getCalorie())
        .protein(foodDTO.getProtein())
        .carbohydrate(foodDTO.getCarbohydrate())
        .sugar(foodDTO.getSugar())
        .natrium(foodDTO.getNatrium())
        .build();

        return foodRepository.save(food).getBno();
        // FoodDTO를 Food 엔티티로 변환
        //Food foodEntity = modelMapper.map(foodDTO, Food.class);

        // Food 엔티티를 저장하고 저장된 엔티티의 ID를 반환
        //Food savedFood = foodRepository.save(foodEntity);

        // 저장된 Food 엔티티의 ID를 반환
        //return savedFood.getBno();
    }
}
