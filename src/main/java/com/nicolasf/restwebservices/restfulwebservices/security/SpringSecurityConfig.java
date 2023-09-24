package com.nicolasf.restwebservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //All requests must be authenticated
        //http.authorizeHttpRequests(
        //        auth -> auth.anyRequest().authenticated()
        //);
        //If a req is not authenticated, a web page is
        http.httpBasic(withDefaults());
        //CSRF is disabled
        http.csrf().disable();

        return http.build();
    }

}
