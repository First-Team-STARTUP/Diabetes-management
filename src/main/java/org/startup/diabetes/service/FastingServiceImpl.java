package org.startup.diabetes.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.startup.diabetes.domain.Fasting;
import org.startup.diabetes.domain.Member;
import org.startup.diabetes.dto.FastingDTO;
import org.startup.diabetes.repository.FastingRepository;
import org.startup.diabetes.repository.FoodRepository;
import org.startup.diabetes.repository.MemberRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class FastingServiceImpl implements FastingService {

    private final ModelMapper modelMapper;
    private FastingRepository fastingRepository;
    private final MemberRepository memberRepository;

    // register 메서드는
    // FastingDTO 객체를 받아서 modelMapper를 사용하여 Fasting 엔터티로 변환하고
    // 그 후에 fastingRepository를 사용하여 데이터베이스에 저장
    // save 메서드는 결과를 반환하며, 해당 결과에서 getBno() 메서드를 호출

    @Override
    public Long register(@Valid FastingDTO fastingDTO, UserDetails userDetail) {

        Member member = memberRepository.findByUserid(userDetail.getUsername())
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        // FastingDTO에서 Fasting 엔터티로 변환
        Fasting fasting = Fasting.builder()
                .registDate(fastingDTO.getRegistDate())
                .emptyData(fastingDTO.getEmptyData())
                .member(member)
                .build(); // A->B , fasting

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
        Fasting fasting = result.orElseThrow();

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


    @Override
    public void remove(Long bno) {
        fastingRepository.deleteById(bno);
    }


    @Override
    public List<FastingDTO> findByUserid(String userid) {
        // 해당 유저의 Fasting 정보 가져오기
        List<Fasting> fastingList = fastingRepository.findByMemberUserid(userid);

        // Fasting 엔티티를 FastingDTO로 변환하여 리스트에 추가
        List<FastingDTO> fastingDTOList = new ArrayList<>();
        for (Fasting fasting : fastingList) {
            FastingDTO fastingDTO = FastingDTO.tofastingDTO(fasting);
            fastingDTOList.add(fastingDTO);
        }

        return fastingDTOList;
    }


    @Override
    //중복날짜 조회
    public boolean registDateDuplicated(LocalDate registDate) {
        // 날짜가 중복되면 true, 아니면 false 반환
        return fastingRepository.existsByRegistDate(registDate);
    }


    //공복 50~900입력
    public boolean emptyDataRange(int emptyData) {
        return emptyData >= 50 && emptyData <= 900;
    }


    //--3월7일 재형 - 공복혈당얻어오기위해 씀.
    @Autowired
    public void FastingService(FastingRepository fastingRepository) {
        this.fastingRepository = fastingRepository;
    }

    public List<FastingDTO> findAll() {
        List<Fasting> fastingEntityList = fastingRepository.findAll();
        // fastingEntityList를 FastingDTO로 변환하는 작업을 수행
        // ...
        List<FastingDTO> fastingDTOList = new ArrayList<>();
        for (Fasting fasting : fastingEntityList) {
            fastingDTOList.add(FastingDTO.tofastingDTO(fasting));
            //변환된 객체를 "fastingDTOList"에 받는.. for문돌려서
        }
        return fastingDTOList;

    }
}