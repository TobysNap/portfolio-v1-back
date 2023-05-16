package com.devTN.portfolio.model;

import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    
    @Size(max = 55, message = "Apellido no puede ser mayor a 55 caracteres")
    @NotNull(message = "Apellido no puede ser nulo")
    private String apellido;

    @Size(max = 55, message = "Nombre no puede ser mayor a 55 caracteres")
    @NotNull(message = "Nombre no puede ser nulo")
    private String nombre;

    @Size(min = 10, max = 255, message = "Descripcion debe ser entre 10 y 255 caracteres")
    @NotNull(message = "Descripcion no puede ser nulo")    
    private String descripcion;
   
    @Size(min = 18, message = "Edad no puede ser menor a 18")
    @NotNull(message = "Edad no puede ser nulo")
    private Integer edad;

    @Email(message = "Debe ingresar un email válido")
    @NotNull(message = "Email no puede ser nulo")
    private String email;

    @NotNull(message = "Localidad no puede ser nulo")
    private String localidad;

    @NotNull
    private String picUrl;

    @NotNull
    private String provincia;

    @NotNull
    private String profilePicUrl;

    @NotNull
    private String facebook;

    @NotNull
    private String github;

    @NotNull
    private String instagram;

    @NotNull
    private String linkedin;

    @NotNull
    private String telefono;

    @NotNull
    private String twitter;

    
    public Usuario(){
    }

    public Usuario(Long id,
                   String apellido,
                   String nombre,
                   String descripcion,
                   Integer edad,
                   String email,
                   String picUrl,
                   String localidad,
                   String provincia,
                   String profilePicUrl,
                   String facebook,
                   String github,
                   String instagram,
                   String linkedin,
                   String telefono,
                   String twitter) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.edad = edad;
        this.email = email;
        this.picUrl = picUrl;
        this.localidad = localidad;
        this.provincia = provincia;
        this.profilePicUrl = profilePicUrl;
        this.facebook = facebook;
        this.github = github;
        this.instagram = instagram;
        this.linkedin = linkedin;
        this.telefono = telefono;
        this.twitter = twitter;
    }
}
