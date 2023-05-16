package com.devTN.portfolio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios_creds")
@Getter @Setter
public class UsuarioCred {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String email;

    @NotNull
    private String nombre;

    @NotNull
    private String password;

    public UsuarioCred(String email, String nombre, String password) {
        this.email = email;
        this.nombre = nombre;
        this.password = password;
    }

    public UsuarioCred() {
    }
}
