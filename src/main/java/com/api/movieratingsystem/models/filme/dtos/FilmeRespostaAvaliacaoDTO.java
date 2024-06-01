package com.api.movieratingsystem.models.filme.dtos;

import com.api.movieratingsystem.models.filme.Filme;

public record FilmeRespostaAvaliacaoDTO(Long id, String titulo) {
    public FilmeRespostaAvaliacaoDTO(Filme filme){
        this(filme.getId(), filme.getTitulo());
    }
}
