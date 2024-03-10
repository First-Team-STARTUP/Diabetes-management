package org.startup.diabetes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.startup.diabetes.domain.Board;
import org.startup.diabetes.dto.BoardDTO;

import java.time.LocalDate;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long>{
    List<Board> findByTime(String time);

    // 사용자가 속한 게시판 그룹을 찾는 메서드
    List<Board> findByMemberUserid(String userid);
    List<Board> findByFood_Bno(Long foodId);

    List<Board> findByMemberUseridAndRegistDate(String userid, LocalDate date);

    List<BoardDTO> findBoardByRegistDateAndMemberUserid(LocalDate date, String userid);


    List<Board> findByMember_Id (Long id);

}

