package org.startup.diabetes.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
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
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        Optional<Member> result = memberRepository.findByUserid(userId);

        if(result.isEmpty()){
            throw new UsernameNotFoundException("Userid Not Found"+userId);
        }

        Member member = result.get();

        return User.builder()
                .username(member.getUserid())
                .password(member.getPw())
                .roles("USER")
                .build();


    }
}
