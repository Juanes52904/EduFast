package com.curso.cursojava.Dao;

import com.curso.cursojava.models.Comentarios;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ComentDaoImp implements ComentDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Comentarios> getComentarios() {
        String query = "FROM Comentarios";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        Comentarios comentario = entityManager.find(Comentarios.class, id);
        entityManager.remove(comentario);
    }

    @Override
    public void registar(Comentarios comentario) {
        entityManager.merge(comentario);
    }

}

