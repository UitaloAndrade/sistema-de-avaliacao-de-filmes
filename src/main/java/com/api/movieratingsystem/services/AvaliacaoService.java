package com.api.movieratingsystem.services;

import com.api.movieratingsystem.models.Avaliacao;
import com.api.movieratingsystem.models.Filme;
import com.api.movieratingsystem.repositories.AvaliacaoRepository;
import com.api.movieratingsystem.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private FilmeService filmeService;

    public List<Avaliacao> buscarTodos(){
        return avaliacaoRepository.findAll();
    }

    public Avaliacao buscarPorId(Long id){
        return avaliacaoRepository.findById(id).get();
    }

    public Avaliacao salvar(Long id, Avaliacao avaliacao){
//        Filme filme = filmeService.findById(id);
//        avaliacao.setFilme(filme);
        avaliacao = avaliacaoRepository.save(avaliacao);
        filmeService.atualizarNotaMedia(id);
        return avaliacao;
    }

    public Avaliacao atualizar(Long id, Avaliacao obj){
        Avaliacao avaliacao = avaliacaoRepository.findById(id).get();
        avaliacao.setNota(obj.getNota());
        avaliacao.setComentario(obj.getComentario());
        avaliacao.getFilme().getAvaliacoes().add(avaliacao);
        avaliacao.getFilme().calcularNotaMedia();
        filmeRepository.save(avaliacao.getFilme());
        avaliacao = avaliacaoRepository.save(avaliacao);
        return avaliacao;
    }

    public void deletar(Long id){
        Avaliacao avaliacao = avaliacaoRepository.findById(id).get();
        Filme filme = avaliacao.getFilme();
        filme.removeAvaliacao(avaliacao);
        filmeRepository.save(filme);
    }
}
