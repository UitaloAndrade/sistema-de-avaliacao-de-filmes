package com.api.movieratingsystem.repositories;

import com.api.movieratingsystem.models.avaliacao.Avaliacao;
import com.api.movieratingsystem.models.filme.Filme;
import com.api.movieratingsystem.models.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findByFilme(Filme filme);
    List<Avaliacao> findByUsuario(Usuario usuario);
}
