package org.lessons.java.spring.spring_la_mia_pizzeria_crud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers("/pizze/create", "/pizze/edit/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/pizze/**").hasAuthority("ADMIN")
                .requestMatchers("/offerte", "/offerte/**").hasAuthority("ADMIN")
                .requestMatchers("/pizze", "/pizze/**").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/**").permitAll())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

}
