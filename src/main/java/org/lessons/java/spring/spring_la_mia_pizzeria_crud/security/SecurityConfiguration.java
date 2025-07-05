package org.lessons.java.spring.spring_la_mia_pizzeria_crud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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

    @Bean
    @SuppressWarnings("deprecation")
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    DatabaseUserDetailsService userDetailsService() {
        return new DatabaseUserDetailsService(); // ! strumento per andare a cercare l'utente by username
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder(); // ! in base a quello che mettiamo nel db
                                                                           // prima
                                                                           // ! della password stabilisci quale sia la
                                                                           // ! funzione di hashing che userai
    }

}
