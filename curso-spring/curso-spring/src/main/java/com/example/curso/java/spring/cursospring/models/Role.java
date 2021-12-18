package com.example.curso.java.spring.cursospring.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Role")
public class Role extends BaseEntity{

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "role")
    private Set<Permissions> permissionsSet;


    //Getters & Setters

    public Set<Permissions> getPermissionsSet() {return permissionsSet;}

    public void setPermissionsSet(Set<Permissions> permissionsSet) {this.permissionsSet = permissionsSet;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

}
