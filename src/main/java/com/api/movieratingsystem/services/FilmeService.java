package com.api.movieratingsystem.services;

import com.api.movieratingsystem.models.avaliacao.Avaliacao;
import com.api.movieratingsystem.models.filme.Filme;
import com.api.movieratingsystem.repositories.FilmeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class FilmeService {

    private FilmeRepository repository;
    public Page<Filme> buscarPorTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Filme buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado!"));
    }

    @Transactional
    public Filme salvar(Filme filme) {
        return repository.save(filme);
    }

    @Transactional
    public Filme atualizar(Long id, Filme obj) {
        Filme filme = repository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado!"));
        filme.setTitulo(obj.getTitulo());
        filme.setDiretor(obj.getDiretor());
        filme.setLancamento(obj.getLancamento());
        filme.setSinopse(obj.getSinopse());
        return repository.save(filme);
    }

    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    };

    @Transactional
    public void atualizarNotaMedia(Long id){
        Filme filme = repository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado ao atualizar nota!"));
        List<Avaliacao> list = filme.getAvaliacoes();
        double somaNotas = list.stream().mapToInt(Avaliacao::getNota).sum();
        filme.setNotaMedia( somaNotas / list.size());
        repository.save(filme);
    }
}
