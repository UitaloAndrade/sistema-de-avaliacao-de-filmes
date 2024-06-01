package com.api.movieratingsystem.models.avaliacao.dtos;

import com.api.movieratingsystem.models.avaliacao.Avaliacao;

public record AvaliacaoDTO(Long id, Long filme, Integer nota, String comentario, Long usuario) {
    public AvaliacaoDTO(Avaliacao avaliacao) {
        this(avaliacao.getId(), avaliacao.getFilme().getId(), avaliacao.getNota(), avaliacao.getComentario(), avaliacao.getUsuario().getId());
    }
}
