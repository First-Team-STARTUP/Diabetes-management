package org.startup.diabetes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.startup.diabetes.entity.FastingEntity;

public interface FastingRepository extends JpaRepository<FastingEntity, Long> {


}
