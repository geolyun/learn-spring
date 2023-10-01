package com.in28minutes.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

public class BasicAuthenticationSecurityConfiguration {

    //Filter chain
    // authenticate all requests
    //basic authentication
    //disabling csrf
    //stateless rest api

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 1: Response to preflight request doesn't pass access control check
        // 프리플라이트 요청에 대한 응답이 엑세스 제어 체크를 통과하지 못한다는 오류를 해결
        // 2: basic auth
        // 기본 인증 url 만들기
        http.authorizeHttpRequests(
                auth -> auth
                        // 이 메서드는 요청 타입에 따라 URL 패턴을 지정하여 해당 요청 타입에 대한 보안 설정을 할 때 사용됩니다.
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // 모든 사람에게 모든 URL에 대한 OPTIONS 요청을 허용
                        .anyRequest().authenticated()
        );

        http.httpBasic(Customizer.withDefaults());

        http.sessionManagement(
                session -> session.sessionCreationPolicy
                        (SessionCreationPolicy.STATELESS));

        http.csrf((csrf) -> csrf.disable());

        return http.build();
    }

}
