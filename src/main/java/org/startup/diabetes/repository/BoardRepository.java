package org.startup.diabetes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.startup.diabetes.domain.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity,Long>{

}
