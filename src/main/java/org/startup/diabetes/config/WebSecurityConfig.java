package org.startup.diabetes.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.startup.diabetes.security.UserDetailService;

@Log4j2
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {


    private final UserDetailService userDetailService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeRequests(authorize ->
                authorize
                        .requestMatchers( "member/login", "/member/join","/member/successSignUp","/service").permitAll() //모든사용자에게 허용
                        .anyRequest().authenticated()
        );
        http.formLogin(formLogin ->
                formLogin
                        .loginPage("/member/login")
                        .usernameParameter("userid")
                        .passwordParameter("pw")
                        .defaultSuccessUrl("/service",true) //로그인 후 넘어갈 페이지 설정
                        .permitAll()
        );
        http.logout(logout ->
                logout
                        .logoutSuccessUrl("/member/login") //로그아웃 후 넘어갈 페이지
                        .invalidateHttpSession(true)
        );
        http.sessionManagement(sessionManagement -> //동시접속자 수
                sessionManagement
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(false)
        );
        return http
                .build();
    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {

        // DaoAuthenticationProvider 빈 생성
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        // 사용자 상세 서비스 설정
        daoAuthenticationProvider.setUserDetailsService(userDetailService);

        // 패스워드 인코더 설정
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
