package com.api.movieratingsystem.models;

import com.api.movieratingsystem.models.dto.AvaliacaoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_avaliacao")
@NoArgsConstructor
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
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Avaliacao(Filme filme, Integer nota, String comentario, Usuario usuario){
        this.filme = filme;
        this.nota = nota;
        this.comentario = comentario;
        this.usuario = usuario;
    }
}
