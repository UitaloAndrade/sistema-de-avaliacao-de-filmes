package com.api.movieratingsystem.services;

import com.api.movieratingsystem.models.Avaliacao;
import com.api.movieratingsystem.models.Filme;
import com.api.movieratingsystem.models.Usuario;
import com.api.movieratingsystem.models.dto.AtualizarAvaliacao;
import com.api.movieratingsystem.models.dto.AvaliacaoDTO;
import com.api.movieratingsystem.models.dto.RegistrerAvaliacaoDTO;
import com.api.movieratingsystem.repositories.AvaliacaoRepository;
import com.api.movieratingsystem.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AvaliacaoService {

    private AvaliacaoRepository avaliacaoRepository;
    private UsuarioRepository usuarioRepository;
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
        Usuario usuario = usuarioRepository.findById(id).get();
        return avaliacaoRepository.findByUsuario(usuario);
    }

    @Transactional
    public Avaliacao salvar(RegistrerAvaliacaoDTO avaliacaoDTO){
        Usuario usuario = recuperarUsuario();
        var filme = filmeService.buscarPorId(avaliacaoDTO.filme());

        var avaliacao = new Avaliacao(filme, avaliacaoDTO.nota(), avaliacaoDTO.comentario(), usuario);

        avaliacaoRepository.save(avaliacao);
        filmeService.atualizarNotaMedia(filme.getId());

        return avaliacao;
    }

    @Transactional
    public Avaliacao atualizar(Long id, AtualizarAvaliacao obj) throws Exception {
        Avaliacao avaliacao = avaliacaoRepository.findById(id).get();
        var usuario = recuperarUsuario();

        if(!avaliacao.getUsuario().getId().equals(usuario.getId())){
            throw new Exception("Essa avaliação nao pertence a esse usuario");
        }
        Integer nota = avaliacao.getNota();

        avaliacao.setNota(obj.nota());
        avaliacao.setComentario(obj.comentario());
        avaliacaoRepository.save(avaliacao);

        if (!nota.equals(obj.nota())) {
            filmeService.atualizarNotaMedia(avaliacao.getFilme().getId());
        }
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

    public Usuario recuperarUsuario(){
        // Obter o usuário autenticado
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = ((Usuario) authentication.getPrincipal()).getUsername();

        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario;
    }
}
