package org.startup.diabetes.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member implements UserDetails {
                                    // User Details를 상속받아 인증 객체로 사용

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userid;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private int tall;

    @Column(nullable = false)
    private int weight;


    @Override //권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }


    @Override   // 사용자의 id를 반환 (고유의 값)
    public String getUsername() {
        return userid;
    }

    @Override   // 사용자의 패스워드를 반환
    public String getPassword() {
        return pw;
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
