package com.app.lhgame.spring.config;

import com.app.lhgame.spring.security.Custom403Handler;
import com.app.lhgame.spring.security.CustomLoginSuccessHandler;
import com.app.lhgame.spring.security.CustomUserDetailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@Log4j2
public class CustomSecurityConfig {

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new CustomLoginSuccessHandler();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        //페이지 권한 설정
        http.authorizeHttpRequests()
                // .antMatchers("/").authenticated() // 해당 페이지 요청시 인증 요구
                .antMatchers("/").permitAll() //누구나 다 들어옴
                .antMatchers("/sample/member").hasRole("USER") //role 정의
                .antMatchers("/sample/admin").hasRole("ADMIN");

        // 로그인 페이지
        http.formLogin().loginPage("/login").successHandler(successHandler());

        // 403 에러시 처리(권한 문제)
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());

        //로그아웃 페이지
        http.logout();//.logoutUrl("/logout");

        //자동 로그인
        http.rememberMe().key("123456789").rememberMeParameter("remember-me").tokenValiditySeconds(60*60*24);

        return http.build();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new Custom403Handler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails userDetails = User.builder()
                .username("user1")
                .password(passwordEncoder().encode("1111"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }*/
}
