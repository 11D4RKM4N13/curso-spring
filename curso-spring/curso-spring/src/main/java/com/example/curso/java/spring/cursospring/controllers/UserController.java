package com.example.curso.java.spring.cursospring.controllers;

import com.example.curso.java.spring.cursospring.models.user;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    //Trae todos los usurios
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<user> getAll()
    {

        List<user> list = new ArrayList<>();
        user usuario = new user();

        usuario.setNombre("Edwin");
        usuario.setApellido("Suarez");
        usuario.setEmail("edwin.suarez@gsdplus.com");
        usuario.setTelefono("3208556455");

        list.add(usuario);

        return list;

    }

    //Trae un solo usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    user getUserbyid(@PathVariable Long id)
    {

        user usuario = new user();

        usuario.setNombre("Andrea");
        usuario.setApellido("Martinez");

        return usuario;

    }

    //Registrar un usuario
    @RequestMapping(value = "/", method = RequestMethod.POST)
    user setUser(@RequestBody user usuario)
    {

        //TODO: Registrar usuario en la DB
        return usuario;

    }

    //Actualizar un usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    user updateUser(@RequestBody user usuario)
    {

        //TODO: Actualizar usuario en la DB
        return usuario;

    }

    //Eliminar un usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteUser(@PathVariable Long id)
    {

        //TODO: Eliminar usuario en la DB

    }

}
