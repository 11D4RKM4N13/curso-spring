package com.example.curso.java.spring.cursospring.controllers;

import com.example.curso.java.spring.cursospring.models.user;
import com.example.curso.java.spring.cursospring.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    userService userservice;

    //Trae todos los usuarios
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<user> getAll()
    {
        return userservice.getAll();
    }

    //Trae un solo usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    user getUserbyid(@PathVariable Long id)
    {
        return userservice.getUserbyid(id);
    }

    //Registrar un usuario
    @RequestMapping(value = "/", method = RequestMethod.POST)
    user setUser(@RequestBody user usuario)
    {
        return userservice.setUser(usuario);
    }

    //Actualizar un usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    user updateUser(@RequestBody user usuario)
    {
        return userservice.updateUser(usuario);
    }

    //Eliminar un usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteUser(@PathVariable Long id)
    {
        userservice.deleteUser(id);
    }

}
