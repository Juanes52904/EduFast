package com.curso.cursojava.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name= "foros")
@ToString @EqualsAndHashCode
public class Foro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "titulo")
    private String titulo;

    @Getter @Setter @Column(name = "subtitulo")
    private String subtitulo;

    @Getter @Setter @Column(name = "descripcion")
    private String descripcion;

    @Getter @Setter @Column(name = "id_usuario")
    private String id_usuario;

}
