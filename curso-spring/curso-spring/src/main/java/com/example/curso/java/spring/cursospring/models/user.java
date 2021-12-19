package com.example.curso.java.spring.cursospring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class user extends BaseEntity {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    @Getter @Setter
    private Role role;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password")
    @Getter @Setter
    private String password;

    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

    @Column(name = "apellido")
    @Getter @Setter
    private String apellido;

    @Column(name = "email")
    @Getter @Setter
    private String email;

    @Column(name = "telefono")
    @Getter @Setter
    private String telefono;

    @Column(name = "fechaNacimiento")
    @Getter @Setter
    private Date fechaNacimiento;

    //Sobre carga de metodos

    public user()
    {}

    public user(String nombre, String apellido, String email, String telefono, Long id, Date fechaNacimiento)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        setId(id);
        this.fechaNacimiento = fechaNacimiento;
    }
}
