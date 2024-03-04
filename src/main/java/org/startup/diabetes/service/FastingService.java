package org.startup.diabetes.service;

import org.springframework.validation.Errors;
import org.startup.diabetes.dto.FastingDTO;
import org.startup.diabetes.dto.PageRequestDTO;
import org.startup.diabetes.dto.PageResponseDTO;

// DTO -> Entity (Entity Class)
// Entity -> DTO (DTO Class)

public interface FastingService {
    Long register(FastingDTO fastingDTO);

    // 조회
    FastingDTO readOne(Long bno);

    // 수정
    void modify(FastingDTO fastingDTO);

    // 삭제
    void remove(Long bno);

    // 목록&검색 기능
    // 페이징 처리된 데이터를 전달
    //PageResponseDTO<FastingDTO> list(PageRequestDTO pageRequestDTO);

    //유효성 체크
    //String validateHandling(Errors errors);


}

