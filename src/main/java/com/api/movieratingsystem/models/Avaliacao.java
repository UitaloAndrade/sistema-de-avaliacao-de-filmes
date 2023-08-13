package com.api.movieratingsystem.models;

import com.api.movieratingsystem.models.dto.AvaliacaoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_avaliacao")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class Avaliacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "filme_id", nullable = false)
    private Filme filme;
    private Integer nota;
    private String comentario;

    public Avaliacao(AvaliacaoDTO obj){
        this.filme = obj.filme();
        this.nota = obj.nota();
        this.comentario = obj.comentario();
    }
}
