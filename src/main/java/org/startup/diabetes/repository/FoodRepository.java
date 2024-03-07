package org.startup.diabetes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.startup.diabetes.domain.Fasting;
import org.startup.diabetes.domain.Food;

import java.time.LocalDate;
import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

}