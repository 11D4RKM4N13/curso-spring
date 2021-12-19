package com.example.curso.java.spring.cursospring.DAO.DAOimpl;

import com.example.curso.java.spring.cursospring.DAO.UserDAO;
import com.example.curso.java.spring.cursospring.models.user;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public user updateUser(user usuario) {return entityManager.merge(usuario);}

    @Transactional
    @Override
    public void deleteUser(Long id)
    {
        user usuarios = getUserbyid(id);
        entityManager.remove(usuarios);
    }

    @Transactional
    @Override
    public user login(user dto) {
        boolean isAuthenticated = false;

        String hql = "FROM User as u WHERE u.password is not null and u.email = :email";

        List<user> result = entityManager.createQuery(hql.toString())
                .setParameter("email", dto.getEmail())
                .getResultList();
        if (result.size() == 0) { return null; }

        user user = result.get(0);
        isAuthenticated = true;

        if (!StringUtils.isEmpty(dto.getPassword())) {
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            isAuthenticated = argon2.verify(user.getPassword(), dto.getPassword());
        }
        if (isAuthenticated) {
            return user;
        }
        return null;
    }

}
