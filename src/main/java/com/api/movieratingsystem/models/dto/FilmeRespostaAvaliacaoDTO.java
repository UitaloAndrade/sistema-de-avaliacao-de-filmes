package com.api.movieratingsystem.models.dto;

import com.api.movieratingsystem.models.Filme;

public record FilmeRespostaAvaliacaoDTO(Long id, String titulo) {
    public FilmeRespostaAvaliacaoDTO(Filme filme){
        this(filme.getId(), filme.getTitulo());
    }
}
