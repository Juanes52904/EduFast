package com.curso.cursojava.controllers;

import com.curso.cursojava.Dao.ComentDao;
import com.curso.cursojava.models.Comentarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ComentController {

    @Autowired
    private ComentDao comentDao;


    @RequestMapping(value = "api/comentario/{id}", method = RequestMethod.GET)
    public Comentarios getComentario(@PathVariable Long id){
        Comentarios com = new Comentarios();
        com.setId(122l);
        com.setId_usuario("sarita");
        com.setComentarios("asdasd");
        return com;
    }
    @RequestMapping(value = "api/comentarios")
    public List<Comentarios>getComentarios(){
        return comentDao.getComentarios();
    }

    @RequestMapping(value = "api/comentario/{id}", method = RequestMethod.DELETE)
    public void eliminarComentario(@PathVariable Long id){
        comentDao.eliminar(id);
    }


    @RequestMapping(value = "api/comentarios", method = RequestMethod.POST)
    public void registrarComentarios(@RequestBody Comentarios comentario){
        comentDao.registar(comentario);
    }

}
