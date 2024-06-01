package com.api.movieratingsystem.models.dto;

import com.api.movieratingsystem.models.Avaliacao;
import com.api.movieratingsystem.models.Filme;
import com.api.movieratingsystem.models.Usuario;

public record AvaliacaoDTO(Long id, Long filme, Integer nota, String comentario, Long usuario) {
    public AvaliacaoDTO(Avaliacao avaliacao) {
        this(avaliacao.getId(), avaliacao.getFilme().getId(), avaliacao.getNota(), avaliacao.getComentario(), avaliacao.getUsuario().getId());
    }
}
