package com.example.curso.java.spring.cursospring.DAO;

import com.example.curso.java.spring.cursospring.models.user;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

public interface UserDAO {

    List<user> getAll();

    user getUserbyid(Long id);

    user setUser(user usuario);

    user updateUser(user usuario);

    user login(user usuario);

    void deleteUser(Long id);

}
