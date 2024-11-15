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
            // ログインの設定
            .formLogin(login -> login
                .defaultSuccessUrl("/")  // ログイン成功後に遷移するURL
                .failureUrl("/login?error")  // ログイン失敗時のURL
                .permitAll()  // ログインページは誰でもアクセス可能
            )
            // ログアウトの設定
            .logout(logout -> logout
                .logoutUrl("/logout")  // ログアウトを行うURL（デフォルトの"/logout"を指定）
                .logoutSuccessUrl("/") // ログアウト成功後にリダイレクトするURL
                .invalidateHttpSession(true)  // セッションを無効化
                .deleteCookies("JSESSIONID")  // JSESSIONIDを削除
                .permitAll()  // ログアウトURLも全ユーザーがアクセスできるようにする
            )
            .authorizeHttpRequests(authz -> authz
                // 静的リソースのアクセス許可
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .permitAll()  // 静的リソースは誰でもアクセス可能
                
                // パブリックなページ
                .requestMatchers("/", "/schools/**")
                .permitAll()  // これらのURLは全ユーザーがアクセス可能
                
                // 管理者用ページ
                .requestMatchers("/admin/**")
                .hasRole("ADMIN")  // "ADMIN" ロールが必要
                
                // その他は認証が必要
                .anyRequest().authenticated()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // パスワードエンコーダーの設定
    }
}