package com.curso.cursojava.Dao;

import com.curso.cursojava.models.Foro;

import java.util.*;

public interface ForoDao {

    List<Foro> getForos();

    void eliminar(Long id);

    void registrar(Foro foro);
}
