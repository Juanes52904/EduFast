package com.curso.cursojava.Dao;

import java.util.*;
import com.curso.cursojava.models.usuario;

public interface usuarioDao {


    List<usuario> getUsuarios();

    void eliminar(Long id);

    void registrar(usuario usuario);

    usuario obtenerUsuarioPorCredenciales(usuario usuario);

}
