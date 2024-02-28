package org.startup.diabetes.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.startup.diabetes.repository.MemberRepository;
@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        return memberRepository.findByUserid(userid)
                .orElseThrow(() -> new IllegalArgumentException((userid)));
    }
}
