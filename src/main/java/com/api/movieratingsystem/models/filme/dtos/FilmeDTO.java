package com.api.movieratingsystem.models.filme.dtos;

import com.api.movieratingsystem.models.filme.Filme;

import java.time.LocalDate;

public record FilmeDTO(String titulo, String diretor, LocalDate lancamento, String sinopse, Double notaMedia) {

   public FilmeDTO(Filme filme){

       this(filme.getTitulo(), filme.getDiretor(), filme.getLancamento(), filme.getSinopse(), filme.getNotaMedia());
   }
}
