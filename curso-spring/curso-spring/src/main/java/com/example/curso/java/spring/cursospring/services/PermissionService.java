package com.example.curso.java.spring.cursospring.services;

import com.example.curso.java.spring.cursospring.DAO.PermissionDAO;
import com.example.curso.java.spring.cursospring.DAO.UserDAO;
import com.example.curso.java.spring.cursospring.models.Permissions;
import com.example.curso.java.spring.cursospring.models.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PermissionService
{

    @Autowired
    PermissionDAO permissionDAO;

    public List<Permissions> getAll()
    {
        return  permissionDAO.getAll();
    }

    public Permissions getPermissionbyid(Long id)
    {
        return permissionDAO.getPermissionbyid(id);
    }

    public Permissions setPermission(Permissions permissions)
    {
        return permissionDAO.setPermission(permissions);
    }


    public Permissions updatePermission(@RequestBody Permissions permissions) {return permissionDAO.updatePermission(permissions);}


    public void deletePermission(@PathVariable Long id)
    {
        permissionDAO.deletePermission(id);
    }

}
