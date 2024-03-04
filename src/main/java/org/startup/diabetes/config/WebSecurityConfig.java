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
                        .requestMatchers( "member/login", "/member/join").permitAll()
                        .anyRequest().authenticated()
        );
        http.formLogin(formLogin ->
                formLogin
                        .loginPage("/member/login")
                        .usernameParameter("userid")
                        .passwordParameter("pw")
                        .defaultSuccessUrl("/")
                        .permitAll()
        );
        http.logout(logout ->
                logout
                        .logoutSuccessUrl("/member/login")
                        .invalidateHttpSession(true)
        );
        http.sessionManagement(sessionManagement ->
                sessionManagement
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(false)
        );
        return http
                .build();
    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() throws Exception{

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }




    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // @AuthenticationPrincipal을 이용하여 로그인 정보를 가져오는 메소드 추가
    // 이 메소드는 현재 로그인한 사용자의 정보를 받아옵니다.
    // 만약 사용자가 로그인하지 않은 상태라면 principal은 null이 됩니다.
    public String getCurrentUserId(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            return userDetails.getUsername();
        } else {
            return null;
        }
    }
}
