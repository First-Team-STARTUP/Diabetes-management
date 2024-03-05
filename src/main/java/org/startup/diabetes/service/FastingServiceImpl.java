package org.startup.diabetes.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.startup.diabetes.domain.Fasting;
import org.startup.diabetes.dto.FastingDTO;
import org.startup.diabetes.repository.FastingRepository;
import java.util.*;


@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class FastingServiceImpl implements FastingService {

    private final ModelMapper modelMapper;
    private final FastingRepository fastingRepository;

    // register 메서드는
    // FastingDTO 객체를 받아서 modelMapper를 사용하여 Fasting 엔터티로 변환하고
    // 그 후에 fastingRepository를 사용하여 데이터베이스에 저장
    // save 메서드는 결과를 반환하며, 해당 결과에서 getBno() 메서드를 호출

    @Override
    public Long register(@Valid FastingDTO fastingDTO) {

        // FastingDTO에서 Fasting 엔터티로 변환
        Fasting fasting = modelMapper.map(fastingDTO, Fasting.class); // A->B , fasting

        // Fasting 엔터티를 데이터베이스에 저장하고 저장된 엔터티의 ID를 얻음
        //bno 데이터베이스에 Fasting 엔터티를 저장한 결과
        Long bno = fastingRepository.save(fasting).getBno(); //fastin 담아서 repository저장

        return bno;

//        Fasting fasting = Fasting.builder()
//                .emptyData(fastingDTO.getEmptyData())
//                .build();
//
//        return fastingRepository.save(fasting).getBno();
    }


    // 조회
    // findById 메서드를 통해 데이터베이스에서 특정 Fasting 엔터티를 조회
    @Override
    public FastingDTO readOne(Long bno) {
        // Optional<>
        // 1 findById 메서드를 사용하여 데이터베이스에서 emptyId에 해당하는 Fasting 엔터티를 조회
        // 2 조회 결과는 Optional<Fasting> 형태로 반환, 조회된 결과가 없을 수도 있다는 것
        Optional<Fasting> result = fastingRepository.findById(bno);
        // result.orElseThrow()를 통해 값이 없는 경우 예외
        Fasting fasting= result.orElseThrow();

        // modelMapper를 사용하여 Fasting 엔터티를 FastingDTO로 변환
        // 엔터티 객체와 DTO 객체 사이의 필드 매핑을 자동으로 수행
        FastingDTO fastingDTO = modelMapper.map(fasting, FastingDTO.class);

        return fastingDTO;
    }

    @Override
    public void modify(FastingDTO fastingDTO) {
        Optional<Fasting> result = fastingRepository.findById(fastingDTO.getBno());
        Fasting fasting = result.orElseThrow();

        fasting.change(fastingDTO.getEmptyData());
        fastingRepository.save(fasting);

    }

    //삭제
//    @Override
//    public void remove(FastingDTO fastingDTO) {
//        // FastingDTO에서 ID를 추출하여 삭제
//        Long emptyId = fastingDTO.getEmptyId();
//        fastingRepository.deleteById(emptyId);
//    }
    @Override
    public void remove(Long bno) {
        fastingRepository.deleteById(bno);
    }


    //조회
    public List<FastingDTO> findAll(){
        //List 형태의 엔티티가 넘어오게 됨
        List<Fasting> fastingList = fastingRepository.findAll();
        // 엔티티 객체를 DTO로 저장 -> controller -> service
        List<FastingDTO> fastingDTOList = new ArrayList<>();

        // fastingList 엔티티 -> FastingDTO 변환하고
        for(Fasting fasting: fastingList){
            // FastingDTO 변환된 객체를 fastingDTOList에 담는다
            fastingDTOList.add(FastingDTO.tofastingDTO(fasting));
        }

        return fastingDTOList;
    }

//    public boolean AlreadyRegistered(LocalDate date) {
//        // 해당 날짜로 이미 등록된 데이터가 있는지 확인
//        return fastingRepository.existsByRegistDate(date);
//    }

}