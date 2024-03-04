package org.startup.diabetes.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.startup.diabetes.domain.Member;
import org.startup.diabetes.repository.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {

        Optional<Member> member = memberRepository.findByUserid(userid);

        if(member.isEmpty()){
            throw new UsernameNotFoundException("Userid Not Found");
        }

        return memberRepository.findByUserid(userid)
                .orElseThrow(() -> new IllegalArgumentException((userid)));



//        Member member1 = member.get();
//
//        return new User(
//                member1.getUserid(),
//                member1.getPw(),
//                AuthorityUtils.createAuthorityList("ROLE_USER")
//        );
    }
}
