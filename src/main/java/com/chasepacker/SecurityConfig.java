package com.chasepacker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.chasepacker.DBManager.ConnectionFailedException;

@Configuration
@EnableWebSecurity
@EnableScheduling
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/login").permitAll()
                    .requestMatchers("/token").permitAll()
                    .requestMatchers("/register").permitAll()
                    .requestMatchers("/api/**").permitAll() // Allow all API requests
                    .requestMatchers("/diary/**").permitAll() // Allow all diary requests, tokens will be validated in the controller
                    .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf.disable())
            .sessionManagement(sessionManagement ->
                sessionManagement
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Use stateless sessions
            );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        System.out.println("Password encoder bean created");
        return new BCryptPasswordEncoder();
    }

    @Bean 
    public DBManager dbManager() {
        int attempts = 0;
        int maxAttempts = 5;
        
        while (attempts < maxAttempts) {
            try {
                return new DBManager();
            } 
            catch (ConnectionFailedException e) {
                attempts++;
                if (attempts >= maxAttempts) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return null; // This line should never be reached
    }

}
