package org.startup.diabetes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FastingService {

//    private final FastingRepository emptyRepository;
//
//    @Transactional
//    public CreateEmptyResponse createEmpty(CreateEmptyRequest request){
//        FastingEntity empty = FastingEntity.builder()
//                .emptyData(request.getEmptyData())
//                .datetime(request.getDatetime())
//                .build();
//
//        FastingEntity saveEmpty = emptyRepository.save(empty);
//        return new CreateEmptyResponse(saveEmpty.getEmptyId(), saveEmpty.getEmptyData(), saveEmpty.getDatetime());
//    }


}
