package com.example.code_step.token;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FirebaseTokenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) { //header 가 있는지 판단
            String token = header.substring(7); //앞에 Barer 삭제

            System.out.println("token : " + token);

            try{
                FirebaseToken decodeToken = FirebaseAuth.getInstance().verifyIdToken(token);// 들어온 토큰을 검증


                //아마 토큰이 유효하지 않으면 자동으로 Exception를 발생시킬것 같긴한데 한 번 확인 필요.

                if(decodeToken != null) {
                    servletRequest.setAttribute("uid", decodeToken.getUid());
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } catch (FirebaseAuthException e) {
                throw new ServletException("Invalid Firebase Token ",e);
            }

        }else
            throw new ServletException("Authorization header is invalid");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
