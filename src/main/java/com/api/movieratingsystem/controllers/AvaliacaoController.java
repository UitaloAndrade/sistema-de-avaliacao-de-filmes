package com.api.movieratingsystem.controllers;

import com.api.movieratingsystem.models.AvaliacaoModel;
import com.api.movieratingsystem.services.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public ResponseEntity<List<AvaliacaoModel>> findAll(){
        List<AvaliacaoModel> avaliacoes = avaliacaoService.findAll();
        return ResponseEntity.ok().body(avaliacoes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoModel> findById(@PathVariable Long id){
        AvaliacaoModel avaliacao = avaliacaoService.findById(id);
        return ResponseEntity.ok().body(avaliacao);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoModel> save(@RequestBody AvaliacaoModel avaliacao){
        avaliacao = avaliacaoService.save(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacao);
    }

    @PutMapping
    public ResponseEntity<AvaliacaoModel> update(@RequestBody AvaliacaoModel avaliacao){
        avaliacao = avaliacaoService.update(avaliacao);
        return ResponseEntity.ok().body(avaliacao);
    }

//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id){
//        avaliacaoService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
}
