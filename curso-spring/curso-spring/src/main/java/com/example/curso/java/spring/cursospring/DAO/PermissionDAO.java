package com.example.curso.java.spring.cursospring.DAO;

import com.example.curso.java.spring.cursospring.models.Permissions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface PermissionDAO {

    List<Permissions> getAll();

    Permissions getPermissionbyid(Long id);

    Permissions setPermission(Permissions permissions);

    Permissions updatePermission(Permissions permissions);

    void deletePermission(Long id);

}
