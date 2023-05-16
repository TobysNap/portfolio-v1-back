package com.devTN.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "habilidades")
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nombre no puede ser nulo")
    @Size(max = 55, message = "Nombre no puede ser mayor a 55 caracteres")
    private String nombre;
    
    @NotNull(message = "Descripcion no puede ser nulo")
    @Size(max = 155, message = "Descripcion no puede ser mayor a 155 caracteres")
    private String descripcion;
    
    @NotNull(message = "Puntaje no puede ser nulo")
    @Max(value = 10, message = "Puntaje no puede ser mayor a 10 puntos")
    private Integer puntaje;
    
    @NotNull(message = "Tipo de Habilidad no puede ser nulo")
    private String tipoHabilidad;
    
    @NotNull(message = "Usuario no puede ser nulo")
    @ManyToOne
    private Usuario usuario;
    
    
    public Habilidad() {
    }
    
    public Habilidad(Long id, String descripcion, String nombre, Integer puntaje,
            String tipoHabilidad, Usuario usuario) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.tipoHabilidad = tipoHabilidad;
        this.usuario = usuario;
    }
}
