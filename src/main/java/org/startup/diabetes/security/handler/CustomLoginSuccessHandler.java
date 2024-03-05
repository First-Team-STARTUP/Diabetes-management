//package org.startup.diabetes.security.handler;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.startup.diabetes.security.MemberSecurityDTO;
//
//import java.io.IOException;
//
//@Log4j2
//@RequiredArgsConstructor
//public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
//
//
//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                        Authentication authentication) throws IOException, ServletException {
//
//        log.info("-------------------------------------------------------------------");
//        log.info("CustomLoginSuccessHandler onAuthenticationSuccess .................");
//        log.info(authentication.getPrincipal());
//
//        MemberSecurityDTO memberSecurityDTO = (MemberSecurityDTO) authentication.getPrincipal();
//
//        String encodedPw = memberSecurityDTO.getPw();
//
//        if (memberSecurityDTO.getUserid().equals(memberSecurityDTO.getUserid())
//                && passwordEncoder.matches(encodedPw, memberSecurityDTO.getPw())){
//
//            log.info("Access to Member's My page");
//            response.sendRedirect("/member/mypage");
//
//            return;
//        } else {
//
//            log.info("Not your Account");
//            response.sendRedirect("/member/login");
//        }
//    }
//}
//
//