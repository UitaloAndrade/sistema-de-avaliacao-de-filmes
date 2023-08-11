package com.api.movieratingsystem.services;

import com.api.movieratingsystem.models.AvaliacaoModel;
import com.api.movieratingsystem.models.FilmeModel;
import com.api.movieratingsystem.records.FilmeRecord;
import com.api.movieratingsystem.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public List<FilmeRecord> findAll(){
        List<FilmeModel> list = repository.findAll();
        return list.stream().map(x -> new FilmeRecord(x.getId(), x.getTitulo(), x.getDiretor(), x.getLancamento(), x.getSinopse(), x.getNotaMedia())).toList();
    }

    public FilmeRecord findById(Long id){
        FilmeModel filme = repository.findById(id).get();
        return parseFilmeRecord(filme);
    }

    public FilmeRecord save(FilmeRecord record){
        FilmeModel filme = new FilmeModel(record);
        filme.setNotaMedia(filme.getNotaMedia());
        repository.save(filme);
        return parseFilmeRecord(filme);
    }

    public FilmeRecord update(FilmeRecord record){
        FilmeModel filme = repository.findById(record.id()).get();
        filme.setTitulo(record.titulo());
        filme.setDiretor(record.diretor());
        filme.setLancamento(record.lancamento());
        filme.setSinopse(record.sinopse());
        filme = repository.save(filme);
        return parseFilmeRecord(filme);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public void deletarComentario(Long id_filme, Long id_avaliacao){
        FilmeModel filme = repository.findById(id_filme).get();
        filme.deletarComentario(id_avaliacao);
        repository.save(filme);
    }

    private FilmeRecord parseFilmeRecord(FilmeModel filmeModel){
        return new FilmeRecord(filmeModel.getId(), filmeModel.getTitulo(), filmeModel.getDiretor(), filmeModel.getLancamento(), filmeModel.getSinopse(), filmeModel.getNotaMedia());
    }
}
