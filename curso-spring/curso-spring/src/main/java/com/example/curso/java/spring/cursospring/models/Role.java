package com.example.curso.java.spring.cursospring.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Role")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity{

    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "role")
    @Getter @Setter
    private Set<Permissions> permissionsSet;

}
