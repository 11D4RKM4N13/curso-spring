package com.example.curso.java.spring.cursospring.DAO;

import com.example.curso.java.spring.cursospring.models.Role;

import java.util.List;

public interface RoleDAO {

    List<Role> getAll();

    Role getRolebyid(Long id);

    Role setRole(Role role);

    Role updateRole(Role role);

    void deleteRole(Long id);

}
