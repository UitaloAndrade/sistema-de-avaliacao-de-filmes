package com.api.movieratingsystem.controllers;

import com.api.movieratingsystem.models.AvaliacaoModel;
import com.api.movieratingsystem.models.FilmeModel;
import com.api.movieratingsystem.services.AvaliacaoService;
import com.api.movieratingsystem.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
