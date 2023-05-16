package com.devTN.portfolio.security;

import com.devTN.portfolio.model.Usuario;
import java.util.Collection;
import java.util.Collections;

import com.devTN.portfolio.model.UsuarioCred;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    
    private final UsuarioCred usuarioCred;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return usuarioCred.getPassword();
    }

    //Implementación con email en lugar de nombre de usuario
    @Override
    public String getUsername() {
        return usuarioCred.getEmail();
    }

    public String getNombre() {
        return usuarioCred.getNombre();
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
        return true;
    }
    
}
