package org.startup.diabetes.security;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
@ToString
public class MemberSecurityDTO  extends User {

    private Long id;

    private String userid;

    private String pw;

    private String name;

    private Integer age;

    private String gender;

    private Integer tall;

    private Integer weight;

    public MemberSecurityDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userid = username;
        this.pw = password;
    }

    @Override
    public String getUsername() {
        return this.userid;
    }

}
