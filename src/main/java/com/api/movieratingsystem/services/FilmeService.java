package com.api.movieratingsystem.services;

import com.api.movieratingsystem.controllers.AvaliacaoController;
import com.api.movieratingsystem.models.AvaliacaoModel;
import com.api.movieratingsystem.models.FilmeModel;
import com.api.movieratingsystem.repositories.AvaliacaoRepository;
import com.api.movieratingsystem.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public List<FilmeModel> findAll(){
        return repository.findAll();
    }

    public Double calcularMedia(Long id){
        Optional<FilmeModel> filme = repository.findById(id);
        List<AvaliacaoModel> avaliacoes = avaliacaoRepository.findByFilme(filme.get());
        return nota(avaliacoes);
    }

    private Double nota(List<AvaliacaoModel> avaliacoes){
        double media = 0d;
        for (AvaliacaoModel x: avaliacoes) {
            media += x.getNota();
        }
        media = media / avaliacoes.size();
        return media;
    }
}
