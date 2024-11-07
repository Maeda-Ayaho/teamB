package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/", "/login", "/public/**").permitAll() // ここで "/" を追加
                .anyRequest().authenticated() // その他は認証を要求
            )
            .formLogin(login -> login
                .loginPage("/login") // ログインページの指定
                .permitAll() // ログインページは誰でもアクセス可能
                .defaultSuccessUrl("/home", true) // ログイン成功後に /home にリダイレクト
            )
            .logout(logout -> logout
                .permitAll() // ログアウトは誰でも可能
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // パスワードエンコーダーの設定
    }
}
