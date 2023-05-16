package com.devTN.portfolio.security;

import com.devTN.portfolio.model.UsuarioCred;
import com.devTN.portfolio.repository.UsuarioCredRepository;
import com.devTN.portfolio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    
    @Autowired
    private UsuarioCredRepository usuarioCredRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioCred usuarioCred = usuarioCredRepository
                .findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email " + email + " no existe."));
    
        return new UserDetailsImpl(usuarioCred);
    }
    
}
