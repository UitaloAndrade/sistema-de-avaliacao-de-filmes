package com.api.movieratingsystem.controllers;

import com.api.movieratingsystem.models.Filme;
import com.api.movieratingsystem.models.dto.FilmeDTO;
import com.api.movieratingsystem.services.FilmeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/filmes")
@Tag(name = "Filme")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @Operation(summary = "Busca todos os filmes")
    @GetMapping
    public ResponseEntity<Page<FilmeDTO>> buscarPorTodos(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        Page<Filme> filmes = filmeService.buscarPorTodos(pageable);
        return ResponseEntity.ok().body(filmes.map(filme -> new FilmeDTO(filme)));
    }

    @Operation(summary = "Busca o filme pelo ID")
    @GetMapping(value = "/{id}")
    public ResponseEntity<FilmeDTO> buscarPorId(@PathVariable Long id){
        Filme filme = filmeService.buscarPorId(id);
        return ResponseEntity.ok().body(new FilmeDTO(filme));
    }

    @Operation(summary = "Salva um filme")
    @PostMapping
    public ResponseEntity<FilmeDTO> salvar(@RequestBody FilmeDTO filmeDTO){
        Filme filme = filmeService.salvar(new Filme(filmeDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(new FilmeDTO(filme));
    }

    @Operation(summary = "Atualiza o filme")
    @PutMapping(value = "/{id}")
    public ResponseEntity<FilmeDTO> atualizar(@PathVariable Long id, @RequestBody FilmeDTO filmeDTO){
        Filme filme = filmeService.atualizar(id, new Filme(filmeDTO));
        return ResponseEntity.ok().body(new FilmeDTO(filme));
    }

    @Operation(summary = "Deleta um filme")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        filmeService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
