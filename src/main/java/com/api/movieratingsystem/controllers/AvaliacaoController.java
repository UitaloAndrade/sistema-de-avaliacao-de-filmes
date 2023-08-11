package com.api.movieratingsystem.controllers;

import com.api.movieratingsystem.records.AvaliacaoRecord;
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
    public ResponseEntity<List<AvaliacaoRecord>> findAll(){
        List<AvaliacaoRecord> avaliacoes = avaliacaoService.findAll();
        return ResponseEntity.ok().body(avaliacoes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoRecord> findById(@PathVariable Long id){
        AvaliacaoRecord avaliacao = avaliacaoService.findById(id);
        return ResponseEntity.ok().body(avaliacao);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoRecord> save(@RequestBody AvaliacaoRecord avaliacao){
        avaliacao = avaliacaoService.save(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacao);
    }

    @PutMapping
    public ResponseEntity<AvaliacaoRecord> update(@RequestBody AvaliacaoRecord avaliacao){
        avaliacao = avaliacaoService.update(avaliacao);
        return ResponseEntity.ok().body(avaliacao);
    }
}
