package com.devTN.portfolio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
@Entity
@Table(name = "educaciones")
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    
    @NotNull(message = "Carrera no puede ser nulo")
    @Size(max = 55, message = "Carrera no debe ser mayor a 55 caracteres")
    private String carrera;

    @NotNull(message = "Establecimiento no puede ser nulo")
    @Size(max = 55, message = "Establecimiento no debe ser mayor a 55 caracteres")
    private String establecimiento;

    @NotNull
    private String periodo;

    @NotNull(message = "Titulo no puede ser nulo")
    @Size(max = 55, message = "Titulo no debe ser mayor a 55 caracteres")
    private String titulo;
    
    @NotNull(message = "Usuario no puede ser nulo")
    @ManyToOne
    private Usuario usuario;
    
    
    public Educacion() {}
    
    public Educacion(Long id,
                     String carrera,
                     String establecimiento,
                     String periodo,
                     String titulo,
                     Usuario usuario) {
        this.id = id;
        this.carrera = carrera;
        this.establecimiento = establecimiento;
        this.periodo = periodo;
        this.titulo = titulo;
        this.usuario = usuario;
    }
    
}
