package com.hourlogix.backend_api.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecConfig {
    // order of the requestMatchers() elements is significant; the more specific
    // rules need to come first, followed by the more general ones.
    // authenrtication first then authorization
    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        // Disable default CORS handling
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/api/v1/hourlogix/manager/**").hasRole("MANAGER")
            .requestMatchers("/api/v1/hourlogix/employee/**").authenticated()
            .requestMatchers("/api/v1/hourlogix/login").permitAll()
            .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults()); // Enable HTTP Basic auth

    
    http.cors(cors -> cors.configurationSource(request -> {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(List.of("http://localhost:4200")); 
        corsConfig.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        corsConfig.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        corsConfig.setAllowCredentials(true);
        corsConfig.setMaxAge(3600L);

        // TODO customize logout to clear data and cookies
        // https://docs.spring.io/spring-security/reference/servlet/authentication/logout.html#clear-all-site-data

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return corsConfig;
    }));

    return http.build();
}


    // @Bean
    // CorsConfigurationSource corsConfigurationSource() {
    //     CorsConfiguration configuration = new CorsConfiguration();
    //     configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
    //     configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
    //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //     source.registerCorsConfiguration("/**", configuration);
    //     return source;
    // }

    // encrypts passwords- hashing algo, convert string to secret data
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    // @Bean
    // public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
    //         throws Exception {
    //     return authenticationConfiguration.getAuthenticationManager();
    // }
}

// These expressions allow us to access the principal object representing the
//
// current authorized (or anonymous) user and the current Authentication object
//
// from the SecurityContext

// We can, for example, use principal to load a user’s email, avatar, or any
//
// other data that’s accessible from the logged-in user.

// And authentication provides information about the full Authentication object,
//
// along with its granted authorities.