package com.example.code_step.token;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FirebaseTokenFilter extends OncePerRequestFilter {
    private List<String> excludePatterns;
    private final AntPathMatcher matcher;

    public FirebaseTokenFilter(List<String> excludePatterns) {
        this.excludePatterns = excludePatterns;
        matcher = new AntPathMatcher();
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String uri = request.getRequestURI();
        System.out.println("uri : " + uri);
        return excludePatterns.stream().anyMatch(pattern  -> matcher.match(pattern, uri));

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) { //header 가 있는지 판단
            String token = header.substring(7); //앞에 Barer 삭제

            System.out.println("token : " + token);

            try{
                FirebaseToken decodeToken = FirebaseAuth.getInstance().verifyIdToken(token);// 들어온 토큰을 검증

                //아마 토큰이 유효하지 않으면 자동으로 Exception를 발생시킬것 같긴한데 한 번 확인 필요.
                if(decodeToken != null) {
                    request.setAttribute("uid", decodeToken.getUid());
                    filterChain.doFilter(request, response);
                    return;
                }
            } catch (FirebaseAuthException e) {
                throw new ServletException("Invalid Firebase Token ",e);
            }
        }else
            throw new ServletException("Authorization header is invalid");

    }

}
