package com.api.movieratingsystem.models.dto;

import com.api.movieratingsystem.models.Avaliacao;
import com.api.movieratingsystem.models.Filme;
import com.api.movieratingsystem.models.Usuario;

public record AvaliacaoDTO(Long id, Filme filme, Integer nota, String comentario, Usuario usuario) {
    public static AvaliacaoDTO newAvaliacaoDTO(Avaliacao avaliacao) {
        return new AvaliacaoDTO(avaliacao.getId(), avaliacao.getFilme(), avaliacao.getNota(), avaliacao.getComentario(), avaliacao.getUsuario());
    }
}
