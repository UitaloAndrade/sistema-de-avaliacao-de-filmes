package com.api.movieratingsystem.services;

import com.api.movieratingsystem.models.FilmeModel;
import com.api.movieratingsystem.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public List<FilmeModel> findAll(){
        return repository.findAll();
    }

    public FilmeModel findById(Long id){
        Optional<FilmeModel> filme = repository.findById(id);
        return filme.get();
    }

    public FilmeModel save(FilmeModel filme){
        filme = repository.save(filme);
        return filme;
    }

    public FilmeModel update(Long id, FilmeModel obj){
        FilmeModel filme = repository.findById(id).get();
        filme.setTitulo(obj.getTitulo());
        filme.setDiretor(obj.getDiretor());
        filme.setLancamento(obj.getLancamento());
        filme.setSinopse(obj.getSinopse());
        filme = repository.save(filme);
        return filme;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
