package com.devTN.portfolio.service;

import com.devTN.portfolio.model.Usuario;
import com.devTN.portfolio.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService  {

    @Autowired
    UsuarioRepository usuarioRepository;   

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void editUsuario(Long id, Usuario usuario) {
        Usuario usu = this.verUsuario(id);
        usu.setId(id);
        usu.setApellido(usuario.getApellido());
        usu.setNombre(usuario.getNombre());
        usu.setDescripcion(usuario.getDescripcion());
        usu.setEdad(usuario.getEdad());
        usu.setEmail(usuario.getEmail());
        usu.setPicUrl(usuario.getPicUrl());
        usu.setLocalidad(usuario.getLocalidad());
        usu.setProvincia(usuario.getProvincia());
        usu.setProfilePicUrl(usuario.getProfilePicUrl());
        usu.setFacebook(usuario.getFacebook());
        usu.setGithub(usuario.getGithub());
        usu.setInstagram(usuario.getInstagram());
        usu.setLinkedin(usuario.getLinkedin());
        usu.setTelefono(usuario.getTelefono());
        usu.setTwitter(usuario.getTwitter());
        this.newUsuario(usu);
    }

    @Override
    public void newUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario verUsuario(Long id) {
       return usuarioRepository.findById(id).orElse(null);
    }
    
    @Override
    public List<Usuario> verUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }
}
