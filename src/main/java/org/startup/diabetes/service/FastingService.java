package org.startup.diabetes.service;

import org.startup.diabetes.dto.FastingDTO;

// DTO -> Entity (Entity Class)
// Entity -> DTO (DTO Class)

public interface FastingService {
    Long register(FastingDTO fastingDTO);

}

