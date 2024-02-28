package org.startup.diabetes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.startup.diabetes.domain.Fasting;


public interface FastingRepository extends JpaRepository<Fasting, Long> {
}
