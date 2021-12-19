package com.example.curso.java.spring.cursospring.DAO.DAOimpl;

import com.example.curso.java.spring.cursospring.DAO.RoleDAO;
import com.example.curso.java.spring.cursospring.models.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class RoleDAOimpl implements RoleDAO {

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    @Override
    public List<Role> getAll() {
        String hql = "From Role as r";
        return (List<Role>) entityManager.createQuery(hql);
    }

    @Transactional
    @Override
    public Role getRolebyid(Long id) {return entityManager.find(Role.class ,id);}

    @Transactional
    @Override
    public Role setRole(Role role) {
        entityManager.merge(role);
        return role;
    }

    @Transactional
    @Override
    public Role updateRole(Role role) {
        return entityManager.merge(role);
    }

    @Transactional
    @Override
    public void deleteRole(Long id) {
        Role role = getRolebyid(id);
        entityManager.remove(role);
    }
}
