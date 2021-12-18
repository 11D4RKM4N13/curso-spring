package com.example.curso.java.spring.cursospring.DAO.DAOimpl;

import com.example.curso.java.spring.cursospring.DAO.UserDAO;
import com.example.curso.java.spring.cursospring.models.user;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import java.util.List;

@Transactional
@Repository
public class userDAOimpl implements UserDAO {

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    @Override
    public List<user> getAll()
    {
        String hql = "From user as u";
        return (List<user>) entityManager.createQuery(hql).getResultList();
    }

    @Transactional
    @Override
    public user getUserbyid(Long id)
    {
        return entityManager.find(user.class, id);
    }

    @Transactional
    @Override
    public user setUser(user usuario)
    {
        entityManager.merge(usuario);
        return usuario;
    }

    @Transactional
    @Override
    public user updateUser(user usuario)
    {
        return entityManager.merge(usuario);
    }

    @Transactional
    @Override
    public void deleteUser(Long id)
    {
        user usuarios = getUserbyid(id);
        entityManager.remove(usuarios);
    }

}
