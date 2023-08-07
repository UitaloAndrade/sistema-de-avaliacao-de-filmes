package com.api.movieratingsystem.controllers;

import com.api.movieratingsystem.models.FilmeModel;
import com.api.movieratingsystem.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public ResponseEntity<List<FilmeModel>> findAll(){
        List<FilmeModel> movies = filmeService.findAll();
        return ResponseEntity.ok().body(movies);
    }
    @GetMapping(value = "/mediaavalicao/{id}")
    public ResponseEntity<Double> getMediaNota(@PathVariable Long id){
        Double nota = filmeService.calcularMedia(id);
        return ResponseEntity.ok().body(nota);
    }
}
