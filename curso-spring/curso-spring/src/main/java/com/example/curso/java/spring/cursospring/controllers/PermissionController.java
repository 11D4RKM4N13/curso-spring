package com.example.curso.java.spring.cursospring.controllers;

import com.example.curso.java.spring.cursospring.models.Permissions;
import com.example.curso.java.spring.cursospring.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("permissions")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    //Trae todos los permisos
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Permissions> getAll()
    {
        return permissionService.getAll();
    }

    //Trae un solo permiso
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Permissions getUserbyid(@PathVariable Long id)
    {
        return permissionService.getPermissionbyid(id);
    }

    //Registrar un permiso
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Permissions setPermission(@RequestBody Permissions permissions) {return permissionService.setPermission(permissions);}

    //Actualizar un permiso
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Permissions updatePermission(@RequestBody Permissions permissions) {return permissionService.updatePermission(permissions);}

    //Eliminar un permiso
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deletePermission(@PathVariable Long id) {permissionService.deletePermission(id);}

}