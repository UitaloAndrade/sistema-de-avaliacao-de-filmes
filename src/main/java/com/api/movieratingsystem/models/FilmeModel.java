package com.api.movieratingsystem.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_filme")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class FilmeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String diretor;
    private String lancamento;
    private String sinopse;
    @JsonIgnore
    @OneToMany(mappedBy = "filme")
    private List<AvaliacaoModel> avaliacoes = new ArrayList<>();
    private Double notaMedia;

    public FilmeModel(String titulo, String diretor, String lancamento, String sinopse){
        this.titulo = titulo;
        this.diretor = diretor;
        this.lancamento = lancamento;
        this.sinopse = sinopse;
    }
}
