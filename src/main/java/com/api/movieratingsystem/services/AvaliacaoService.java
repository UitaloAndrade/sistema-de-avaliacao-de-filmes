package com.api.movieratingsystem.services;

import com.api.movieratingsystem.models.AvaliacaoModel;
import com.api.movieratingsystem.records.AvaliacaoRecord;
import com.api.movieratingsystem.repositories.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    public List<AvaliacaoRecord> findAll(){
        List<AvaliacaoModel> list= avaliacaoRepository.findAll();
        return list.stream().map(x -> new AvaliacaoRecord(x.getId(), x.getFilme(), x.getNota(), x.getComentario())).toList();
    }

    public AvaliacaoRecord findById(Long id){
        AvaliacaoModel avaliacao = avaliacaoRepository.findById(id).get();
        return parseAvaliacaoRecord(avaliacao);
    }

    public AvaliacaoRecord save(AvaliacaoRecord record){
        AvaliacaoModel avaliacao = avaliacaoRepository.save(new AvaliacaoModel(record));
        return parseAvaliacaoRecord(avaliacao);
    }

    public AvaliacaoRecord update(AvaliacaoRecord obj){
        AvaliacaoModel avaliacao = avaliacaoRepository.findById(obj.id()).get();
        avaliacao.setNota(obj.nota());
        avaliacao.setComentario(obj.comentario());
        avaliacao = avaliacaoRepository.save(avaliacao);
        return parseAvaliacaoRecord(avaliacao);
    }

    public void delete(Long id){
        avaliacaoRepository.deleteById(id);
    }
    private AvaliacaoRecord parseAvaliacaoRecord(AvaliacaoModel obj){
        return new AvaliacaoRecord(obj.getId(), obj.getFilme(), obj.getNota(), obj.getComentario());
    }
}
