package com.api.movieratingsystem.models.dto;

import com.api.movieratingsystem.models.Filme;

public record FilmeDTO(Long id, String titulo, String diretor, String lancamento, String sinopse, Double notaMedia) {
    public static FilmeDTO newFilmeDTO(Filme filme) {
        return new FilmeDTO(filme.getId(), filme.getTitulo(), filme.getDiretor(), filme.getLancamento(), filme.getSinopse(), filme.getNotaMedia());
    }
}
