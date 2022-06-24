package com.curso.cursojava.Dao;

import com.curso.cursojava.models.Comentarios;

import java.util.*;

public interface ComentDao {
    List<Comentarios> getComentarios();

    void eliminar(Long id);

    void registar(Comentarios comentario);
}
