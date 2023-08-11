package com.api.movieratingsystem.models;

import com.api.movieratingsystem.records.FilmeRecord;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_filme")
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class FilmeModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String titulo;
    private String diretor;
    private String lancamento;
    private String sinopse;
    private Double notaMedia;
    @JsonIgnore
    @OneToMany(mappedBy = "filme", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Setter(AccessLevel.NONE)
    private List<AvaliacaoModel> avaliacoes = new ArrayList<>();

    public FilmeModel(String titulo, String diretor, String lancamento, String sinopse){
        this.titulo = titulo;
        this.diretor = diretor;
        this.lancamento = lancamento;
        this.sinopse = sinopse;
    }

    public FilmeModel(FilmeRecord obj){
        this.titulo = obj.titulo();
        this.diretor = obj.diretor();
        this.lancamento = obj.lancamento();
        this.sinopse = obj.sinopse();
    }
}
