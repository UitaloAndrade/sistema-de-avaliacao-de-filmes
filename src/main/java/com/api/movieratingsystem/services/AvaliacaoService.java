package com.api.movieratingsystem.services;

import com.api.movieratingsystem.models.AvaliacaoModel;
import com.api.movieratingsystem.repositories.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    @Autowired
    private FilmeService filmeService;
    public List<AvaliacaoModel> findAll(){
        return avaliacaoRepository.findAll();
    }

    public AvaliacaoModel findById(Long id){
        return avaliacaoRepository.findById(id).get();
    }

    public AvaliacaoModel save(AvaliacaoModel avaliacao){
        avaliacao = avaliacaoRepository.save(avaliacao);
        filmeService.atualizarNotaMedia(avaliacao.getFilme().getId());
        return avaliacao;
    }

    public AvaliacaoModel update(AvaliacaoModel obj){
        AvaliacaoModel avaliacao = findById(obj.getId());
        avaliacao.setNota(obj.getNota());
        avaliacao.setComentario(obj.getComentario());
        return save(avaliacao);
    }
//    public void delete(Long id){
//        AvaliacaoModel avaliacao = avaliacaoRepository.findById(id).get();
//        FilmeModel filme = avaliacao.getFilme();
//        filme.getAvaliacoes().remove(avaliacao);
//        filmeService.atualizarNotaMedia(filme.getId());
//        avaliacaoRepository.deleteById(avaliacao.getId());
//    }
}
