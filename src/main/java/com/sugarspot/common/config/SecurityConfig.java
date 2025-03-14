package com.sugarspot.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final CustomAccessDeniedHandler customAccessDeniedHandler;

    private final String[] swaggerUrls = {"/swagger-ui/**", "/v3/**"};
}
