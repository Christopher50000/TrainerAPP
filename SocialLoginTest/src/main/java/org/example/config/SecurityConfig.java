package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/").permitAll(); //Permit everyone to go on that page
                    auth.anyRequest().authenticated(); // any other Request they have to be authenticated
                })
                .oauth2Login(withDefaults())
                .formLogin(withDefaults())
                .build();
        // we need to go into application .properties to authorize what clients we are going to support
    }
}
