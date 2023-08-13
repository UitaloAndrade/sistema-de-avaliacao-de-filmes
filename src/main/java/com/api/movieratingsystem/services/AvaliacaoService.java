package com.api.movieratingsystem.services;

import com.api.movieratingsystem.models.Avaliacao;
import com.api.movieratingsystem.models.Filme;
import com.api.movieratingsystem.models.Usuario;
import com.api.movieratingsystem.repositories.AvaliacaoRepository;
import com.api.movieratingsystem.repositories.FilmeRepository;
import com.api.movieratingsystem.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
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

    public List<Avaliacao> buscarPorFilme(Long id){
        Filme filme = filmeRepository.findById(id).get();
        return avaliacaoRepository.findByFilme(filme);
    }
    public List<Avaliacao> buscarPorUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id).get();
        return avaliacaoRepository.findByUsuario(usuario);
    }

    public Avaliacao salvar(Avaliacao avaliacao){
        Filme filme = filmeRepository.findById(avaliacao.getFilme().getId()).get();
        Usuario usuario = usuarioRepository.findById(avaliacao.getUsuario().getId()).get();
        avaliacao.setUsuario(usuario);
        avaliacao.setFilme(filme);
        avaliacaoRepository.save(avaliacao);
        filmeService.atualizarNotaMedia(filme.getId());
        return avaliacao;
    }

    public Avaliacao atualizar(Long id, Avaliacao obj){
        Avaliacao avaliacao = avaliacaoRepository.findById(id).get();
        avaliacao.setNota(obj.getNota());
        avaliacao.setComentario(obj.getComentario());
        avaliacaoRepository.save(avaliacao);
        filmeService.atualizarNotaMedia(avaliacao.getFilme().getId());
        return avaliacao;
    }

    public void deletar(Long id){
        Avaliacao avaliacao = avaliacaoRepository.findById(id).get();
        Filme filme = avaliacao.getFilme();
        filme.getAvaliacoes().remove(avaliacao);
        filmeRepository.save(filme);
        filmeService.atualizarNotaMedia(filme.getId());
    }
}
