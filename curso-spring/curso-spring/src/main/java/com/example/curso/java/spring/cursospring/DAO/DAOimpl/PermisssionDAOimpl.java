package com.example.curso.java.spring.cursospring.DAO.DAOimpl;

import com.example.curso.java.spring.cursospring.DAO.PermissionDAO;
import com.example.curso.java.spring.cursospring.models.Permissions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class PermisssionDAOimpl implements PermissionDAO {

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    @Override
    public List<Permissions> getAll() {
        String hql = "From permissions as p";
        return (List<Permissions>) entityManager.createQuery(hql);
    }

    @Transactional
    @Override
    public Permissions getPermissionbyid(Long id) {return entityManager.find(Permissions.class, id);}

    @Transactional
    @Override
    public Permissions setPermission(Permissions permissions)
    {
        entityManager.merge(permissions);
        return permissions;
    }

    @Override
    public Permissions updatePermission(Permissions permissions) {return entityManager.merge(permissions);}

    @Override
    public void deletePermission(Long id) {
        Permissions permissions = getPermissionbyid(id);
        entityManager.remove(permissions);
    }
}
