package com.example.curso.java.spring.cursospring.controllers;

import com.example.curso.java.spring.cursospring.models.user;
import com.example.curso.java.spring.cursospring.services.userService;
import com.example.curso.java.spring.cursospring.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    userService userservice;

    @Autowired
    private JWTUtils jwtUtils;

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
    void setUser(@RequestBody user usuario) {userservice.setUser(usuario);}

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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Map<String, Object> login(@RequestBody user dto)
    {
        user usuario = userService.login(dto);

        Map<String, Object> result = new HashMap<>();
        if (usuario != null)
        {
            String token = jwtUtils.create(String.valueOf(usuario.getId()), usuario.getEmail());
            result.put("token", token);
            result.put("usuario", usuario);
        }

        return result;

    }

}
