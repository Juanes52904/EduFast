package com.curso.cursojava.controllers;

import com.curso.cursojava.Dao.usuarioDao;
import com.curso.cursojava.models.usuario;
import com.curso.cursojava.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private usuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody usuario usuario){

        usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);

       if  (usuarioLogueado != null )  {
           String tokenJwt =  jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
           return tokenJwt;
       }
       return "fail";
    }


}
