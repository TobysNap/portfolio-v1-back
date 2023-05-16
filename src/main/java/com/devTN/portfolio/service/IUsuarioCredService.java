package com.devTN.portfolio.service;

import com.devTN.portfolio.model.Usuario;
import com.devTN.portfolio.model.UsuarioCred;

import java.util.List;

public interface IUsuarioCredService {
    public void deleteUsuarioCred(Long id);

    public void newUsuarioCred(UsuarioCred usuarioCred);

    public boolean existsByEmail(String email);

}
