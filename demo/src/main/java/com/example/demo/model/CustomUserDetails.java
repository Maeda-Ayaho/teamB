package com.example.demo.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// UserDetailsを継承しているので
// Spring Securityの認証クラスとして認識される
public class CustomUserDetails implements UserDetails {
    // 自作のUserクラスを持つように拡張する
    private Admin admin;
		
    public CustomUserDetails(Admin admin) {
        this.admin = admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return admin.getAuthorities().stream()
            .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
            .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return admin.getPassword(); // カスタム Admin エンティティのパスワードを返す
    }

    @Override
    public String getUsername() {
        return admin.getUsername(); // カスタム Admin エンティティのユーザー名を返す
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // アカウントが期限切れでないかを示す
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // アカウントがロックされていないかを示す
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 資格情報（パスワード）が期限切れでないかを示す
    }

    @Override
    public boolean isEnabled() {
        return admin.isEnabled(); // カスタム Admin エンティティでユーザーが有効かどうかを返す
    }

    // カスタム Admin エンティティにアクセスするための追加メソッド
    public Admin getUser() {
        return admin;
    }
}