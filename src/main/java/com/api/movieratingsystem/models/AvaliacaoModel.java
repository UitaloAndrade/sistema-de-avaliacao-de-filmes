package com.api.movieratingsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "tb_avaliacao")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class AvaliacaoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "filme_id")
    private FilmeModel filme;
    private Double nota;
    private String comentario;
}
