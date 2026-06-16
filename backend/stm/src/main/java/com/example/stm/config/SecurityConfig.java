package com.example.stm.config;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration 
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;
    @Bean
    public SecurityFilterChain securitFilterChain(HttpSecurity http)throws Exception{
        http.csrf(csrf->csrf.disable())
        .authorizeHttpRequests(auth->auth.requestMatchers("/auth/**")
        .permitAll()
        .anyRequest()
        .authenticated()
    )
    .addFilterBefore(
        jwtFilter,UsernamePasswordAuthenticationFilter.class
    );
    return http.build();
    }
    
}
