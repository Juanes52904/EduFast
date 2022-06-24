package com.curso.cursojava.controllers;

import com.curso.cursojava.Dao.ForoDao;
import com.curso.cursojava.models.Foro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class foroController {

    @Autowired
    private ForoDao foroDao;

    @RequestMapping(value = "api/foros/{id}", method = RequestMethod.GET)
    public Foro getForo(@PathVariable Long id){
        Foro foro = new Foro();
        foro.setId(id);
        foro.setTitulo("Complementos Java");
        foro.setSubtitulo("Spring");
        foro.setDescripcion("algunos problemas que tenemos para desarrollar...");
        foro.setId_usuario("juaeorozco@misena.edu.co");
        return foro;
    }

    @RequestMapping(value = "api/foros",method = RequestMethod.GET)
    public List<Foro>getForos(){
        return foroDao.getForos();
    }

    @RequestMapping(value = "api/foros", method = RequestMethod.POST)
    public void registrarForos(@RequestBody Foro foro){
        foroDao.registrar(foro);
    }


    @RequestMapping(value = "api/foros/{id}", method = RequestMethod.DELETE)
    public void eliminarForo(@PathVariable Long id){
        foroDao.eliminar(id);
    }

    @RequestMapping(value = "foro3")
    public Foro buscarForo(){
        Foro foro = new Foro();
        foro.setTitulo("Complementos Java");
        foro.setSubtitulo("Spring");
        foro.setDescripcion("algunos problemas que tenemos para desarrollar...");
        foro.setId_usuario("juaeorozco@misena.edu.co");
        return foro;
    }

}
