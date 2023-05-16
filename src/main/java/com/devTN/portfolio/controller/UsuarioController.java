package com.devTN.portfolio.controller;
/**
 *
 * @author Tobias Napal
 */

import com.devTN.portfolio.model.Usuario;
import com.devTN.portfolio.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService; 

    @DeleteMapping("api/usuario/delete/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }
    
    @GetMapping("api/public/get/usuario/{id}")
    public Usuario verUsuario(@PathVariable Long id) {
        return usuarioService.verUsuario(id);
    }
    
    @GetMapping("api/public/get/usuario")
    @ResponseBody
    public List<Usuario> verUsuarios() {
        return usuarioService.verUsuarios();
    }

    @PostMapping("api/usuario/new")
    public void newUsuario(@RequestBody Usuario usuario) {
        usuarioService.newUsuario(usuario);
    }
    
    @PutMapping("api/usuario/edit/{id}")
    public void editUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuarioService.editUsuario(id, usuario);
    }
}
