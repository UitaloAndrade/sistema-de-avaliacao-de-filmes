package com.api.movieratingsystem.models.filme;

import com.api.movieratingsystem.models.avaliacao.Avaliacao;
import com.api.movieratingsystem.models.filme.dtos.FilmeDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_filme")
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class Filme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String titulo;
    private String diretor;
    private LocalDate lancamento;
    private String sinopse;
    private Double notaMedia;
    @JsonIgnore
    @OneToMany(mappedBy = "filme", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Filme(String titulo, String diretor, LocalDate lancamento, String sinopse){
        this.titulo = titulo;
        this.diretor = diretor;
        this.lancamento = lancamento;
        this.sinopse = sinopse;
    }

    public Filme(FilmeDTO obj){
        this.titulo = obj.titulo();
        this.diretor = obj.diretor();
        this.lancamento = obj.lancamento();
        this.sinopse = obj.sinopse();
    }
}
