package org.startup.diabetes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.startup.diabetes.domain.Fasting;
import org.startup.diabetes.dto.FastingDTO;
import org.startup.diabetes.repository.FastingRepository;

@Service
@RequiredArgsConstructor
public class FastingServiceImpl implements FastingService {

    private final FastingRepository fastingRepository;

    @Override
    public Long register(FastingDTO fastingDTO) {
        Fasting fasting = Fasting.builder()
                .emptyData(fastingDTO.getEmptyData())
                //.dateTime(fastingDTO.getDatetime())
                .build();

        return fastingRepository.save(fasting).getEmptyId();
    }
}