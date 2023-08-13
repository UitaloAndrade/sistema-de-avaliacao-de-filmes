package com.api.movieratingsystem.controllers;

import com.api.movieratingsystem.models.Filme;
import com.api.movieratingsystem.models.dto.FilmeDTO;
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
    public ResponseEntity<List<FilmeDTO>> findAll(){
        List<Filme> filmes = filmeService.buscarPorTodos();
        List<FilmeDTO>  list = filmes.stream().map(x -> new FilmeDTO(x.getId(), x.getTitulo(), x.getDiretor(), x.getLancamento(), x.getSinopse(), x.getNotaMedia())).toList();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FilmeDTO> findById(@PathVariable Long id){
        Filme filme = filmeService.buscarPorId(id);
        return ResponseEntity.ok().body(FilmeDTO.newFilmeDTO(filme));
    }

    @PostMapping
    public ResponseEntity<FilmeDTO> save(@RequestBody FilmeDTO filmeDTO){
        Filme filme = filmeService.salvar(new Filme(filmeDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(FilmeDTO.newFilmeDTO(filme));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<FilmeDTO> atualizar(@PathVariable Long id, @RequestBody FilmeDTO filmeDTO){
        Filme filme = filmeService.atualizar(id, new Filme(filmeDTO));
        return ResponseEntity.ok().body(FilmeDTO.newFilmeDTO(filme));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        filmeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
