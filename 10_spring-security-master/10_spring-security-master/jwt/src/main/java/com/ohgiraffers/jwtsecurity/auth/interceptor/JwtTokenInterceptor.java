package com.ohgiraffers.jwtsecurity.auth.interceptor;

import com.ohgiraffers.jwtsecurity.common.AuthConstants;
import com.ohgiraffers.jwtsecurity.common.utils.TokenUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.rmi.RemoteException;


/*
 * 핸들러 인터셉터 구현체: 요청이 컨트롤러에 도달하기 전에 토큰의 유효성을 검증한다.
 * */

public class JwtTokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String header = request.getHeader(AuthConstants.AUTH_HEADER);

        String token = TokenUtils.splitHeader(header);

        if (token != null) {
            if (TokenUtils.isValidToken(token)) {
                return true;
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "토큰이 만료되었거나 유효하지 않습니다.");
                return false;
            }
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "토큰 정보가 없습니다.");
            return false; // 진행 중단
        }
    }
}
