package com.ohgiraffers.jwtsecurity.auth.filter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.jwtsecurity.auth.model.dto.LoginDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    /**
     * description. 지정된 url(기본적으로 /login) 요청 시 해당 요청을 가로채서 검증 로직을 수행하는 메소드
     *
     * @param request  : HttpServletRequest
     * @param response : HttpServletResponse
     * @return Authentication
     * @throws AuthenticationException
     */

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authRequest;

        try {
            authRequest = getAuthRequest(request);

            setDetails(request, authRequest);// 부가 정보(IP 등) 설정


            return this.getAuthenticationManager().authenticate(authRequest);

        } catch (IOException e) {
            throw new AuthenticationServiceException("로그인 요청 처리 중 입출력 오류 발생", e);
        }
    }

    /**
     * description. 사용자의 로그인 요청 시 요청 정보를 임시 토큰에 저장하는 메소드
     *
     * @param request : HttpServletRequest
     * @return UsernamePasswordAuthenticationToken
     * @throws IOException
     */

    private UsernamePasswordAuthenticationToken getAuthRequest(HttpServletRequest request) throws IOException {

        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);

        LoginDTO user = objectMapper.readValue(request.getInputStream(), LoginDTO.class);

        return new UsernamePasswordAuthenticationToken(user.getUserId(), user.getUserPass());
    }
}

