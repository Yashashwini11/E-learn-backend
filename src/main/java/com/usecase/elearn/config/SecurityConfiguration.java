package com.usecase.elearn.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

        private final JwtAuthenticationFilter jwtAuthFilter;
        private final AuthenticationProvider authenticationProvider;

        private static final String[] PublicEndPoints = {
                        "api/v1/auth/**",
                        "/api/web/sites",
                        "/swagger-ui/**",
                        "/swagger-ui.html/**",
                        "/api/admin/default",
                        "/v3/api-docs/**"
        };

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                                .csrf(AbstractHttpConfigurer::disable)
                                .authorizeHttpRequests(authorize -> authorize
                                                .requestMatchers(PublicEndPoints).permitAll()
                                                .anyRequest().authenticated())
                                .sessionManagement(
                                                session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                                                                .maximumSessions(1))
                                .authenticationProvider(authenticationProvider)
                                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

                return http.build();
        }

        @Bean
        public CorsConfigurationSource corsConfigurationSource() {
                CorsConfiguration corsConfiguration = new CorsConfiguration();
                corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
                corsConfiguration.setAllowedHeaders(Arrays.asList("*")); // Allow all headers
                corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Allow
                                                                                                               // all
                                                                                                               // methods
                corsConfiguration.setAllowCredentials(true);

                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", corsConfiguration);
                return source;
        }
}
