////package com.talkpay.wallet.config;
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.http.SessionCreationPolicy;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.web.cors.CorsConfiguration;
////import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
////import org.springframework.web.cors.CorsConfigurationSource;
////import java.util.List;
////
////@Configuration
////public class SecurityConfig {
////
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////            .cors(cors -> cors.configurationSource(corsConfigurationSource())) // enable CORS
////            .csrf(csrf -> csrf.disable()) // disable CSRF for development
////            .authorizeHttpRequests(auth -> auth
////                .requestMatchers("/api/auth/**").permitAll() // allow login/signup
////                
////                .anyRequest().authenticated() // everything else requires auth
////            )
////            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // stateless API
////            .httpBasic(httpBasic -> httpBasic.disable())
////            .formLogin(form -> form.disable());
////
////        return http.build();
////    }
////
////    @Bean
////    public CorsConfigurationSource corsConfigurationSource() {
////        CorsConfiguration cfg = new CorsConfiguration();
////        cfg.setAllowedOrigins(List.of("http://localhost:5173")); // your React frontend
////        cfg.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
////        cfg.setAllowedHeaders(List.of("*"));
////        cfg.setAllowCredentials(true);
////
////        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////        source.registerCorsConfiguration("/**", cfg);
////        return source;
////    }
////}
////package com.talkpay.wallet.config;
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.http.SessionCreationPolicy;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.web.cors.CorsConfiguration;
////import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
////import org.springframework.web.cors.CorsConfigurationSource;
////
////import java.util.List;
////
////@Configuration
////public class SecurityConfig {
////
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////            .cors(cors -> cors.configurationSource(corsConfigurationSource())) // enable CORS
////            .csrf(csrf -> csrf.disable()) // disable CSRF for development
////            .authorizeHttpRequests(auth -> auth
////                .requestMatchers("/api/auth/**", "/api/wallet/**").permitAll() // allow login/signup + wallet endpoints
////                .anyRequest().authenticated() // everything else requires auth
////            )
////            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // stateless API
////            .httpBasic(httpBasic -> httpBasic.disable())
////            .formLogin(form -> form.disable());
////
////        return http.build();
////    }
////
////    @Bean
////    public CorsConfigurationSource corsConfigurationSource() {
////        CorsConfiguration cfg = new CorsConfiguration();
////        cfg.setAllowedOrigins(List.of("http://localhost:5173")); // your React frontend
////        cfg.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
////        cfg.setAllowedHeaders(List.of("*"));
////        cfg.setAllowCredentials(true);
////
////        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////        source.registerCorsConfiguration("/**", cfg);
////        return source;
////    }
////}
//
//package com.talkpay.wallet.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.cors.CorsConfigurationSource;
//
//import java.util.List;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .cors(cors -> cors.configurationSource(corsConfigurationSource()))  // enable CORS
//            .csrf(csrf -> csrf.disable())  // disable CSRF for API
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers(
//                    "/api/auth/**",       // login/signup
//                    "/api/wallet/**",     // wallet endpoints
//                    "/api/bank/**",       // bank linking endpoints
//                    "/api/cards/**"        // saved cards endpoints
//                ).permitAll()
//                .anyRequest().authenticated()
//            )
//            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//            .httpBasic(httpBasic -> httpBasic.disable())
//            .formLogin(form -> form.disable());
//
//        return http.build();
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration cfg = new CorsConfiguration();
//        cfg.setAllowedOrigins(List.of("http://localhost:5173")); // React frontend
//        cfg.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        cfg.setAllowedHeaders(List.of("*"));
//        cfg.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", cfg);
//        return source;
//    }
//}

package com.talkpay.wallet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))  // enable CORS
            .csrf(csrf -> csrf.disable())  // disable CSRF for API
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/api/auth/**",       // login/signup
                    "/api/wallet/**",     // wallet endpoints
                    "/api/bank/**",       // bank linking endpoints
                    "/api/cards/**",      // saved cards endpoints
                    "/api/bills/**"       // bill payments endpoints
                ).permitAll()
                .anyRequest().authenticated()
            )
            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .httpBasic(httpBasic -> httpBasic.disable())
            .formLogin(form -> form.disable());

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration cfg = new CorsConfiguration();
        cfg.setAllowedOrigins(List.of("http://localhost:5173")); // React frontend
        cfg.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        cfg.setAllowedHeaders(List.of("*"));
        cfg.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cfg);
        return source;
    }
}

