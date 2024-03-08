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

import java.util.List;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class FoodServiceImple implements FoodService {

    private final FoodRepository foodRepository;
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper; // ModelMapper 추가

    // 모든 음식을 가져오는 메서드
//    @Override
//    public List<Food> getAllFoods() {
//
//        return foodRepository.findAll();
//    }

    // 모든 음식을 가져오는 메서드
    @Override
    public List<FoodDTO> getAllFoods() {
        // 해당 유저의 Fasting 정보 가져오기
        List<Food> foodList = foodRepository.findAll();

        // Fasting 엔티티를 FastingDTO로 변환하여 리스트에 추가
        List<FoodDTO> foodDTOList = new ArrayList<>();
        for (Food food : foodList) {
            FoodDTO foodDTO = FoodDTO.toFoodDTO(food);
            foodDTOList.add(foodDTO);
        }

        return foodDTOList;
    }

    @Override
    public Long register(FoodDTO foodDTO) {
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

    @Override
    public List<FoodDTO> findAll() {
        List<Food> foodList = foodRepository.findAll();
        return foodList.stream()
                .map(food -> FoodDTO.builder()
                        .bno(food.getBno())
                        .title(food.getTitle())
                        .plusBlood(food.getPlusBlood())
                        .calorie(food.getCalorie())
                        .protein(food.getProtein())
                        .carbohydrate(food.getCarbohydrate())
                        .sugar(food.getSugar())
                        .natrium(food.getNatrium())
                        .build())
                .collect(Collectors.toList());
    }
}
