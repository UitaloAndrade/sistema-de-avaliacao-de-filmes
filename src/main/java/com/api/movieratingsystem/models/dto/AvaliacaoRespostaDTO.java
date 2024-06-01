package com.api.movieratingsystem.models.dto;

import com.api.movieratingsystem.models.Avaliacao;
import com.api.movieratingsystem.models.Usuario;

public record AvaliacaoRespostaDTO(Long id, Integer nota, String comentario, Long filme, Long usuario) {
    public AvaliacaoRespostaDTO(Avaliacao avaliacao) {
        this(avaliacao.getId(), avaliacao.getNota(), avaliacao.getComentario(), avaliacao.getFilme().getId(), avaliacao.getUsuario().getId());
    }
}
