package com.curso.cursojava.Dao;


import com.curso.cursojava.models.usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
@Transactional

public class UsuarioDaoImp implements usuarioDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<usuario> getUsuarios() {
        String query = "FROM usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        usuario usuario = entityManager.find(usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(usuario usuario) {
        entityManager.merge(usuario);
    }


    @Override
    public usuario obtenerUsuarioPorCredenciales(usuario usuario){
        String query = "FROM usuario WHERE email = :email";
        List<usuario> lista = entityManager.createQuery(query)
                .setParameter("email",usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()){
            return null;
        }

        String passwordHashed = lista.get(0).getPassword();

        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, usuario.getPassword())) {
            return lista.get(0);
        }
        return null;
    }


}
