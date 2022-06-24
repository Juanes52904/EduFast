package com.curso.cursojava.Dao;

import com.curso.cursojava.models.Foro;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;


@Repository
@Transactional
public class ForoDaoImp implements ForoDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Foro> getForos() {
        String query = "FROM Foro";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void eliminar(Long id) {
        Foro foro = entityManager.find(Foro.class,id);
        entityManager.remove(foro);
    }

    @Override
    public void registrar(Foro foro) {
        entityManager.merge(foro);
    }
}
