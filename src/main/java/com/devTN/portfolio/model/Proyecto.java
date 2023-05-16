package com.devTN.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "proyectos")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    
    @NotNull(message = "Nombre no puede ser nulo")
    @Size(max = 55, message = "Nombre no puede ser mayor a 55 caracteres")
    private String nombre;
    
    @NotNull
    private String descripcion;
    
    @NotNull(message = "Url no puede ser nulo")
    private String url;
    
    private String imgUrl;
    
    @NotNull(message = "Usuario no puede ser nulo")
    @ManyToOne
    private Usuario usuario;
    
    
    public Proyecto() {
    }
    
    public Proyecto(Long id,
                    String nombre,
                    String descripcion,
                    String url,
                    String imgUrl,
                    Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.imgUrl = imgUrl;
        this.usuario = usuario;
    }
}
