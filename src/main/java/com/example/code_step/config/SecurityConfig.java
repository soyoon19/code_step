package com.example.code_step.config;

import com.example.code_step.token.FirebaseTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private List<String> excludePatterns = List.of("/join", "/test", "/");

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(auth -> auth.disable());//csrf 비활성화(token 방식에는 필요 없음)
        http
                .formLogin(auth -> auth.disable()); //form 로그인 방식 비활성화
        http
            .authorizeRequests(auth -> auth
                    .anyRequest().permitAll()); //filter 에서 거른다.
        http
                .addFilterBefore(new FirebaseTokenFilter(excludePatterns), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
