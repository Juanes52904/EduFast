package com.curso.cursojava.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name= "respuestas")
@ToString @EqualsAndHashCode
public class Comentarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "id_usuario")
    private String id_usuario;

    @Getter @Setter @Column(name = "comentarios")
    private String comentarios;


}
