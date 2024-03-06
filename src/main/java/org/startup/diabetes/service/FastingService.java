package org.startup.diabetes.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.startup.diabetes.dto.FastingDTO;
import org.startup.diabetes.security.UserDetail;

import java.time.LocalDate;
import java.util.List;

// DTO -> Entity (Entity Class)
// Entity -> DTO (DTO Class)

public interface FastingService {
    Long register(FastingDTO fastingDTO, UserDetails userDetail);

    // 조회
    FastingDTO readOne(Long bno);

    // 수정
    void modify(FastingDTO fastingDTO);

    // 삭제
    void remove(Long bno);

    // 목록&검색 기능
    // 페이징 처리된 데이터를 전달
    //PageResponseDTO<FastingDTO> list(PageRequestDTO pageRequestDTO);

//    List<FastingDTO> findAll();

    //중복날짜 조회
    boolean registDateDuplicated(LocalDate date);

    //공복혈당 50~900입력
    boolean emptyDataRange(int emptyData);

    List<FastingDTO> findByUserid(String userid);


}

