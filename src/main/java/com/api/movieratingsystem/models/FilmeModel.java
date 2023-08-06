package com.api.movieratingsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_filme")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class FilmeModel implements Serializable {

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
}
