package com.api.movieratingsystem.services;

import com.api.movieratingsystem.models.Filme;
import com.api.movieratingsystem.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;
    public List<Filme> findAll() {
        return repository.findAll();
    }

    public Filme findById(Long id) {
        return repository.findById(id).get();
    }

    public Filme save(Filme filme) {
        return repository.save(filme);
    }

    public Filme atualizar(Long id, Filme obj) {
        Filme filme = repository.findById(id).get();
        filme.setTitulo(obj.getTitulo());
        filme.setDiretor(obj.getDiretor());
        filme.setLancamento(obj.getLancamento());
        filme.setSinopse(obj.getSinopse());
        return repository.save(filme);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
