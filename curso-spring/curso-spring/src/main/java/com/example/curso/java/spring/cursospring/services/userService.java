package com.example.curso.java.spring.cursospring.services;

import com.example.curso.java.spring.cursospring.DAO.UserDAO;
import com.example.curso.java.spring.cursospring.models.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class userService {

    @Autowired
    UserDAO userDao;

    public List<user> getAll()
    {
        return  userDao.getAll();
    }

    public user getUserbyid(Long id)
    {
        return userDao.getUserbyid(id);
    }

    public user setUser(user usuario)
    {
        return userDao.setUser(usuario);
    }


    public user updateUser(@RequestBody user usuario)
    {
        return userDao.updateUser(usuario);
    }


    public void deleteUser(@PathVariable Long id)
    {
        userDao.deleteUser(id);
    }

}
