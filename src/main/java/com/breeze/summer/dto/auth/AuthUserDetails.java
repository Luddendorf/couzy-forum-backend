package com.breeze.summer.dto.auth;

import com.breeze.summer.dto.auth.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AuthUserDetails implements OAuth2User, UserDetails {
    private Long id;
    private final String username;
    private final String email;
    private final String password;
    private boolean active;
    private final List<GrantedAuthority> authority;
    private Map<String, Object> attributes;

    public AuthUserDetails(User user) {
        this.username = user.getUserName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.authority = Arrays
                .stream(user.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public AuthUserDetails(long id, String username, String email, String password,
            List<GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authority = authorities;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authority;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public static AuthUserDetails create(User user) {
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

        return new AuthUserDetails(
                user.getCouzyUserId(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                authorities);
    }

    public static AuthUserDetails create(User user, Map<String, Object> attributes) {
        AuthUserDetails userPrincipal = AuthUserDetails.create(user);
        userPrincipal.setAttributes(attributes);
        return userPrincipal;
    }

    public static AuthUserDetails makeFreshUser(User user) {
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));

        return new AuthUserDetails(user.getCouzyUserId(), user.getUserName(),
                user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public String getName() {
        return null;
    }
}
