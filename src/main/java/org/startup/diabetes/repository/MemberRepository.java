package org.startup.diabetes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.startup.diabetes.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String > {

    Optional<Member> findByUserid(String userid);

    boolean existsById(String userid);


}
