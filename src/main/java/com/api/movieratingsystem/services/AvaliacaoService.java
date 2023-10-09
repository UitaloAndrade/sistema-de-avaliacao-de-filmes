package com.api.movieratingsystem.services;

import com.api.movieratingsystem.models.Avaliacao;
import com.api.movieratingsystem.models.Filme;
import com.api.movieratingsystem.models.Usuario;
import com.api.movieratingsystem.repositories.AvaliacaoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AvaliacaoService {

    private AvaliacaoRepository avaliacaoRepository;
    private UsuarioService usuarioService;
    private FilmeService filmeService;

    public Page<Avaliacao> buscarTodos(Pageable pageable){
        return avaliacaoRepository.findAll(pageable);
    }

    public Avaliacao buscarPorId(Long id){
        return avaliacaoRepository.findById(id).get();
    }

    public List<Avaliacao> buscarPorFilme(Long id){
        Filme filme = filmeService.buscarPorId(id);
        return avaliacaoRepository.findByFilme(filme);
    }
    public List<Avaliacao> buscarPorUsuario(Long id){
        Usuario usuario = usuarioService.buscarPorId(id);
        return avaliacaoRepository.findByUsuario(usuario);
    }

    @Transactional
    public Avaliacao salvar(Avaliacao avaliacao){
        Filme filme = filmeService.buscarPorId(avaliacao.getFilme().getId());
        Usuario usuario = usuarioService.buscarPorId(avaliacao.getUsuario().getId());
        avaliacao.setUsuario(usuario);
        avaliacao.setFilme(filme);
        avaliacaoRepository.save(avaliacao);
        filmeService.atualizarNotaMedia(filme.getId());
        return avaliacao;
    }

    @Transactional
    public Avaliacao atualizar(Long id, Avaliacao obj){
        Avaliacao avaliacao = avaliacaoRepository.findById(id).get();
        avaliacao.setNota(obj.getNota());
        avaliacao.setComentario(obj.getComentario());
        avaliacaoRepository.save(avaliacao);
        filmeService.atualizarNotaMedia(avaliacao.getFilme().getId());
        return avaliacao;
    }

    @Transactional
    public void deletar(Long id){
        Avaliacao avaliacao = avaliacaoRepository.findById(id).get();
        Filme filme = avaliacao.getFilme();
        filme.getAvaliacoes().remove(avaliacao);
        filmeService.salvar(filme);
        filmeService.atualizarNotaMedia(filme.getId());
    }
}
