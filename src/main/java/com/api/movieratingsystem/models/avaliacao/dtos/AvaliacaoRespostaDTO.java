package com.api.movieratingsystem.models.avaliacao.dtos;

import com.api.movieratingsystem.models.avaliacao.Avaliacao;

public record AvaliacaoRespostaDTO(Long id, Integer nota, String comentario, Long filme, Long usuario) {
    public AvaliacaoRespostaDTO(Avaliacao avaliacao) {
        this(avaliacao.getId(), avaliacao.getNota(), avaliacao.getComentario(), avaliacao.getFilme().getId(), avaliacao.getUsuario().getId());
    }
}
