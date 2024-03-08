package org.startup.diabetes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.startup.diabetes.domain.Board;
import org.startup.diabetes.domain.Food;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long>{
    List<Board> findByTime(String time);

    // 사용자가 속한 게시판 그룹을 찾는 메서드
    List<Board> findByMemberUserid(String userid);
    List<Board> findByFood_Bno(Long foodId);


}
