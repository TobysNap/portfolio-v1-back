package com.devTN.portfolio.service;

import com.devTN.portfolio.model.Usuario;
import com.devTN.portfolio.model.UsuarioCred;
import com.devTN.portfolio.repository.UsuarioCredRepository;
import com.devTN.portfolio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioCredService implements IUsuarioCredService  {

    @Autowired
    UsuarioCredRepository usuarioCredRepository;

    @Override
    public void deleteUsuarioCred(Long id) {
        usuarioCredRepository.deleteById(id);
    }

    @Override
    public void newUsuarioCred(UsuarioCred usuarioCred) {
        usuarioCredRepository.save(usuarioCred);
    }

    @Override
    public boolean existsByEmail(String email) {
        return usuarioCredRepository.existsByEmail(email);
    }
}
