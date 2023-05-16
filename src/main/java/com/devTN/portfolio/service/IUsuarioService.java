package com.devTN.portfolio.service;

import com.devTN.portfolio.model.Usuario;
import java.util.List;

public interface IUsuarioService {
    public void deleteUsuario(Long id);

    public void editUsuario(Long id, Usuario usuario);
    
    public void newUsuario(Usuario usuario);
    
    public Usuario verUsuario(Long id);
    
    public List<Usuario> verUsuarios();

    public boolean existsByEmail(String email);
}
