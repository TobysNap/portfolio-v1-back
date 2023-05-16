package com.devTN.portfolio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
@Entity
@Table(name = "Experiencias")
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    
    @NotNull(message = "Establecimiento no puede ser nulo")
    @Size(max = 55, message = "Establecimiento no puede ser mayor a 55 caracteres")
    private String establecimiento;
    
    @NotNull(message = "Puesto no puede ser nulo")
    @Size(max = 55, message = "Puesto no puede ser mayor a 55 caracteres")
    private String puesto;
    
    @NotNull(message = "Tipo de Empleo no puede ser nulo")
    private String tipoEmpleo;
    
   @NotNull
   private String periodo;
    
    @NotNull
    private String contactoExperiencia;
    
    @NotNull(message = "Usuario no puede ser nulo")
    @ManyToOne
    private Usuario usuario;
    
    
    public Experiencia() {
    }
    
    public Experiencia(Long id,
                        String establecimiento,
                        String periodo,
                        String puesto,
                        String tipoEmpleo,
                        String contactoExperiencia,
                        Usuario usuario) {
        this.id = id;
        this.establecimiento = establecimiento;
        this.periodo = periodo;
        this.puesto = puesto;
        this.tipoEmpleo = tipoEmpleo;
        this.contactoExperiencia = contactoExperiencia;
        this.usuario = usuario;
    }
}
