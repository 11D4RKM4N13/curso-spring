package com.example.curso.java.spring.cursospring.services;

import com.example.curso.java.spring.cursospring.DAO.RoleDAO;
import com.example.curso.java.spring.cursospring.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleDAO roleDAO;

    public List<Role> getAll() {return roleDAO.getAll();}

    public Role getRolebyid(Long id) {return roleDAO.getRolebyid(id);}

    public Role setRole(Role role) {return roleDAO.setRole(role);}

    public Role updateRole(Role role) {return roleDAO.updateRole(role);}

    public void deleteRole(Long id) {roleDAO.deleteRole(id);}

}
