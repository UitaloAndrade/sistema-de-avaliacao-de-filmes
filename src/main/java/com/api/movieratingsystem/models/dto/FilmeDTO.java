package com.api.movieratingsystem.models.dto;

import com.api.movieratingsystem.models.Filme;

public record FilmeDTO(Long id, String titulo, String diretor, String lancamento, String sinopse, Double notaMedia) {

   public FilmeDTO(Filme filme){
       this(filme.getId(), filme.getTitulo(), filme.getDiretor(), filme.getLancamento(), filme.getSinopse(), filme.getNotaMedia());
   }
}
