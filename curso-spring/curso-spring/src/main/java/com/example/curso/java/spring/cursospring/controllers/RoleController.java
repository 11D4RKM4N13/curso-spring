package com.example.curso.java.spring.cursospring.controllers;

import com.example.curso.java.spring.cursospring.models.Role;
import com.example.curso.java.spring.cursospring.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    RoleService roleService;

    //Trae todos los roles
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Role> getAll()
    {
        return roleService.getAll();
    }

    //Trae un solo rol
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Role getRolebyid(@PathVariable Long id)
    {
        return roleService.getRolebyid(id);
    }

    //Registrar un rol
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Role setRole(@RequestBody Role role) {return roleService.setRole(role);}

    //Actualizar un rol
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Role updateRole(@RequestBody Role role) {return roleService.updateRole(role);}

    //Eliminar un rol
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteRole(@PathVariable Long id) {roleService.deleteRole(id);}

}