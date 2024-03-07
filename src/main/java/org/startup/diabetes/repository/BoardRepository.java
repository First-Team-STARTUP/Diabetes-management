package org.startup.diabetes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.startup.diabetes.domain.BoardEntity;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity,Long>{
    List<BoardEntity> findByTime(String time);
}
