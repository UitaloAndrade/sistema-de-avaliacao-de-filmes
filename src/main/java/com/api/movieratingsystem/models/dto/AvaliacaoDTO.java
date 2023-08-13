package com.api.movieratingsystem.models.dto;

import com.api.movieratingsystem.models.Avaliacao;
import com.api.movieratingsystem.models.Filme;

public record AvaliacaoDTO(Long id, Filme filme, Integer nota, String comentario) {
    public Avaliacao newAvaliacao(){
        return new Avaliacao(this);
    }
    public static AvaliacaoDTO newAvaliacaoDTO(Avaliacao avaliacao) {
        return new AvaliacaoDTO(avaliacao.getId(), avaliacao.getFilme(), avaliacao.getNota(), avaliacao.getComentario());
    }
}
