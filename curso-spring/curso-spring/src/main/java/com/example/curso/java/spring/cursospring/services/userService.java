package com.example.curso.java.spring.cursospring.services;

import com.example.curso.java.spring.cursospring.DAO.PermissionDAO;
import com.example.curso.java.spring.cursospring.DAO.UserDAO;
import com.example.curso.java.spring.cursospring.models.Permissions;
import com.example.curso.java.spring.cursospring.models.user;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service("userService")
public class userService {

    @Autowired
    static
    UserDAO userDao;

    public List<user> getAll()
    {
        return  userDao.getAll();
    }

    public user getUserbyid(Long id)
    {
        return userDao.getUserbyid(id);
    }

    public void setUser(user usuario)
    {
        String hash = generarHash(usuario.getPassword());
        usuario.setPassword(hash);
        userDao.setUser(usuario);
    }

    public user updateUser(@RequestBody user usuario) {return userDao.updateUser(usuario);}

    public void deleteUser(@PathVariable Long id) {userDao.deleteUser(id);}

    public static user login(user usuario)
    {
        return userDao.login(usuario);
    }

    public String generarHash(String password)
    {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.hash(1, 1024 * 1, 1, password);
    }

}
