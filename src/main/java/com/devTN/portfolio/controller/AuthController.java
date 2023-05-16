package com.devTN.portfolio.controller;
/**
 *
 * @author Tobias Napal
 */

import com.devTN.portfolio.dto.JwtDto;
import com.devTN.portfolio.model.Mensaje;
import com.devTN.portfolio.model.UsuarioCred;
import com.devTN.portfolio.security.TokenUtils;
import com.devTN.portfolio.service.IUsuarioCredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private IUsuarioCredService usuarioCredService;

    @DeleteMapping("api/auth/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        usuarioCredService.deleteUsuarioCred(id);
    }


    @PostMapping("api/public/auth/new")
    public ResponseEntity<?> nuevo(@Valid @RequestBody UsuarioCred newUsuario, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Error en los campos"), HttpStatus.BAD_REQUEST);
        if(usuarioCredService.existsByEmail(newUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("Email ya existe"), HttpStatus.BAD_REQUEST);
        UsuarioCred usuarioCred = new UsuarioCred(newUsuario.getEmail(), newUsuario.getNombre(), passwordEncoder.encode(newUsuario.getPassword()));
        usuarioCredService.newUsuarioCred(usuarioCred);
        return new ResponseEntity(new Mensaje("Usuario creado"), HttpStatus.CREATED);
    }

    @PostMapping("api/public/auth/login")
    public ResponseEntity<?> login(@Valid @RequestBody UsuarioCred loginUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Error en los campos"), HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getEmail(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TokenUtils.createToken(loginUsuario.getNombre(), loginUsuario.getEmail());
        JwtDto jwtDto = new JwtDto(jwt);
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

}
