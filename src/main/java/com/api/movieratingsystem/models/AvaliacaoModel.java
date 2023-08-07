package com.api.movieratingsystem.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_avaliacao")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class AvaliacaoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "filme_id", nullable = false)
    private FilmeModel filme;
    private Integer nota;
    private String comentario;
}
