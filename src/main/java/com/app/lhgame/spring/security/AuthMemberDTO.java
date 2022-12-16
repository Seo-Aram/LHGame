package com.app.lhgame.spring.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class AuthMemberDTO extends User {
    private String name;

    public AuthMemberDTO(String username,
                         String password,
                         Collection<? extends GrantedAuthority> authorities,
                         String name) {
        super(username, password, authorities);
        this.name = name;
    }
}
