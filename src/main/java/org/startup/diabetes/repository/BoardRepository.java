package org.startup.diabetes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.startup.diabetes.domain.Board;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long>{
    List<Board> findByTime(String time);
}
