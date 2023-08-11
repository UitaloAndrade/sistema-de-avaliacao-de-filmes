package com.api.movieratingsystem.controllers;

import com.api.movieratingsystem.models.FilmeModel;
import com.api.movieratingsystem.records.FilmeRecord;
import com.api.movieratingsystem.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public ResponseEntity<List<FilmeRecord>> findAll(){
        List<FilmeRecord> filmes = filmeService.findAll();
        return ResponseEntity.ok().body(filmes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FilmeRecord> findById(@PathVariable Long id){
        FilmeRecord filme = filmeService.findById(id);
        return ResponseEntity.ok().body(filme);
    }

    @PostMapping
    public ResponseEntity<FilmeRecord> save(@RequestBody FilmeRecord filme){
        filme = filmeService.save(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(filme);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<FilmeRecord> upadte(@PathVariable Long id, @RequestBody FilmeRecord filme){
        filme = filmeService.update(id, filme);
        return ResponseEntity.ok().body(filme);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        filmeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
