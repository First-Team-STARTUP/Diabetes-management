package org.startup.diabetes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.startup.diabetes.domain.Fasting;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface FastingRepository extends JpaRepository<Fasting, Long> {
    boolean existsByRegistDate(LocalDate registDate);
    List<Fasting> findByMemberUserid(String userid);

}
