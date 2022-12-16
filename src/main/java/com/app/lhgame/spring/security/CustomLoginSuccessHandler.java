package com.app.lhgame.spring.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        AuthMemberDTO authMemberDTO = (AuthMemberDTO) authentication.getPrincipal();

        String password = request.getParameter("password");

        log.info(" pw : " + password);
        boolean passResult = passwordEncoder.matches(password, authMemberDTO.getPassword());

        log.info("password Matches : " + passResult);

        if(passResult) {
            response.sendRedirect("/login?error");
            return;
        }

        List<String> roleNames = new ArrayList<>();
        for(GrantedAuthority authority : authMemberDTO.getAuthorities()) {
            roleNames.add(authority.getAuthority());
        }

        if(roleNames.contains("ROLE_ADMIN")) {
            response.sendRedirect("/sample/admin");
            return;
        } else if(roleNames.contains("ROLE_USER")) {
            response.sendRedirect("/sample/member");
            return;
        }

        response.sendRedirect("/");
    }
}
