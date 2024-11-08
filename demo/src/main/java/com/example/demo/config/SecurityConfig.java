package com.example.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
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
            //ログイン成功時の処理
            .formLogin(login -> login
                // ログインページを表示するURL(POST) →デフォルトのものを表示のため
                //.loginPage("/login")
                // ログイン処理を行うURL(GET)
                //.loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                // ログインできなかった時のURL
                .failureUrl("/login?error")
                // ログインページは誰でもアクセス可能
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login")
                //.permitAll() //★全権限参照可能となる
            )
            .authorizeHttpRequests(authz -> authz
                // resourceフォルダ直下
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .permitAll() //★全権限参照可能となる
                
                .requestMatchers("/","/schools/**")
                .permitAll() //★全権限参照可能となる
                
                .requestMatchers("/admin/**")
                .hasRole("ADMIN")
                .anyRequest().authenticated() // その他は認証を要求
            );


        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // パスワードエンコーダーの設定
    }
}