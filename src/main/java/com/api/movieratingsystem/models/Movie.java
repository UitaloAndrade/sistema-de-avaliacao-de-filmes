package com.api.movieratingsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tb_movie")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String diretor;
    //private Date lancamento;
    private String sinopse;
    //private Double notaMedia;
}
