package com.curso.cursojava.controllers;
import java.sql.Array;
import java.util.*;

import com.curso.cursojava.Dao.usuarioDao;
import com.curso.cursojava.models.usuario;
import com.curso.cursojava.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private usuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public usuario getUsuario(@PathVariable Long id){
        usuario usuario = new usuario();
        usuario.setId(id);
        usuario.setNombre("Juan");
        usuario.setApellido("Orozco");
        usuario.setEmail("juanesorozco46@gmail.com");
        usuario.setTelefono("3123123123");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<usuario> getUsuarios(@RequestHeader(value="Authorization") String token){

        if(!validarToken(token)){return null;}

        return usuarioDao.getUsuarios();
    }

    private boolean validarToken(String token){
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }


    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuarios(@RequestBody usuario usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024,1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id,
                         @RequestHeader(value="Authorization") String token){
        if(!validarToken(token)){return; }
        usuarioDao.eliminar(id);
    }
    @RequestMapping(value = "api/usuario123")
    public usuario buscar(){
        usuario usuario = new usuario();
        usuario.setNombre("");
        usuario.setApellido("");
        usuario.setEmail("");
        usuario.setTelefono("");
        return usuario;
    }
}
