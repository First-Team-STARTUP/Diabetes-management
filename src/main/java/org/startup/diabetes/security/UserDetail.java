package org.startup.diabetes.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.startup.diabetes.domain.Member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail implements UserDetails {

    private Member member;

    @Override //권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return member.getUserid();
            }
        });

        return collection;
    }


    @Override   // 사용자의 id를 반환 (고유의 값)
    public String getUsername() {
        return member.getUserid();
    }

    @Override   // 사용자의 패스워드를 반환
    public String getPassword() {
        return member.getPw();
    }

    @Override   // 계정 만료 여부 반환
    public boolean isAccountNonExpired() {
        return true;
    }   //true -> 만료되지 않음.

    @Override   // 계정잠금 여부 반환
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override// 계정 잠금 여부 반환
    public boolean isCredentialsNonExpired() {
        return true;
    }   // true -> 패스워드가 만료되지 않음

    @Override   //계정 사용 여부 반환
    public boolean isEnabled() {
        return true;
    }   //사용가능함 true
}
