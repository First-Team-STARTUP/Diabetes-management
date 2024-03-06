package org.startup.diabetes.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.startup.diabetes.domain.Fasting;
import org.startup.diabetes.dto.FastingDTO;
import org.startup.diabetes.dto.PageRequestDTO;
import org.startup.diabetes.dto.PageResponseDTO;
import org.startup.diabetes.security.UserDetail;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@Log4j2
public class FastingServiceTests {

    @Autowired
    private FastingService fastingService;

    // 등록
//    @Test
//    public void testRegister(){
//        log.info(fastingService.getClass().getName());
//
//        // builder() 객체의 필드 값을 설정할 수 있음
//        FastingDTO fastingDTO = FastingDTO.builder()
//                .emptyData(11)
//                .build(); //FastingDTO 객체가 생성되어 반환
//
//        Long emptyId = fastingService.register(fastingDTO);
//
//        log.info("emptyId:"  + emptyId);
//    }
//    @Test
//    public void testRegister(){
//
//        IntStream.rangeClosed(1,10).forEach(i -> {
//            FastingDTO fastingDTO = FastingDTO.builder()
//                    .emptyData(i+100)
//                    .build();
//
//            Long result = fastingService.register(fastingDTO,);
//            log.info("bno:" + result);
//        });
//    }


    //수정
    @Test
    public void testModify(){
        FastingDTO fastingDTO = FastingDTO.builder()
                .bno(1L)
                .emptyData(100)
                .build();

        fastingService.modify(fastingDTO);
    }

    //삭제
    @Test
    public void testDelete() {
        Long bno = 1L;
        fastingService.remove(bno);
    }

    //목록&검색
//    @Test
//    public void testList(){
//        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
//                .type("tcw")
//                .keyword("1")
//                .page(1)
//                .size(10)
//                .build();
//
//        PageResponseDTO<FastingDTO> responseDTO = fastingService.list(pageRequestDTO);
//
//        log.info(responseDTO);
//    }
}
