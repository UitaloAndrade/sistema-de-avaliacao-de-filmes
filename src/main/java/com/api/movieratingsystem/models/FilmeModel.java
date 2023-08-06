package com.api.movieratingsystem.models;

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
@Table(name = "tb_movie")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class FilmeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String diretor;
    private Date lancamento;
    private String sinopse;
    @JsonIgnore
    @OneToMany(mappedBy = "filme")
    private List<AvaliacaoModel> avaliacoes = new ArrayList<>();
    private Double notaMedia;

    private void calcularMedia(){
        for (AvaliacaoModel avaliacao: avaliacoes) {
            notaMedia += avaliacao.getNota();
        }
    }
}
