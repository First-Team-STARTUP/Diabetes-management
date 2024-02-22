package org.startup.diabetes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.startup.diabetes.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
