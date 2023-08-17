package com.api.movieratingsystem.models.dto;

import com.api.movieratingsystem.models.Avaliacao;
import com.api.movieratingsystem.models.Usuario;

public record AvaliacaoRespostaDTO(Long id, Integer nota, String comentario, FilmeRespostaAvaliacaoDTO filme, Usuario usuario) {
    public AvaliacaoRespostaDTO(Avaliacao avaliacao) {
        this(avaliacao.getId(), avaliacao.getNota(), avaliacao.getComentario(), new FilmeRespostaAvaliacaoDTO(avaliacao.getFilme()), avaliacao.getUsuario());
    }
}
