package com.example.jobinterview.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests((authorizeRequests) ->
                        authorizeRequests
                                .requestMatchers("/api/auth/registration").permitAll()
                                .requestMatchers("/api/auth/login").permitAll()
                                .requestMatchers("/**").hasRole("USER")
                                .requestMatchers("/api/summary/**")
                                .hasRole("WAITER")
                )
                .httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetails() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("1234")
                .roles("USER")
                .build();

        UserDetails waiter = User.withDefaultPasswordEncoder()
                .username("waiter")
                .password("1234")
                .roles("WAITER")
                .build();

        return new InMemoryUserDetailsManager(user, waiter);
    }
}
