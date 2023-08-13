package com.api.movieratingsystem.controllers;

import com.api.movieratingsystem.models.Avaliacao;
import com.api.movieratingsystem.models.dto.AvaliacaoDTO;
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
    public ResponseEntity<List<AvaliacaoDTO>> buscarTodos(){
        List<Avaliacao> avaliacoes = avaliacaoService.buscarTodos();
        List<AvaliacaoDTO> avaliacaoDTO = avaliacoes.stream().map(x -> new AvaliacaoDTO(x.getId(), x.getFilme(), x.getNota(), x.getComentario(), x.getUsuario())).toList();
        return ResponseEntity.ok().body(avaliacaoDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoDTO> buscarPorId(@PathVariable Long id){
        Avaliacao avaliacao = avaliacaoService.buscarPorId(id);
        return ResponseEntity.ok().body(AvaliacaoDTO.newAvaliacaoDTO(avaliacao));
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoDTO> salvar(@PathVariable Long id, @RequestBody AvaliacaoDTO avaliacaoDTO){
        Avaliacao avaliacao = avaliacaoService.salvar(id, avaliacaoDTO.newAvaliacao());
        return ResponseEntity.status(HttpStatus.CREATED).body(AvaliacaoDTO.newAvaliacaoDTO(avaliacao));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoDTO> atualizar(@PathVariable Long id, @RequestBody AvaliacaoDTO avaliacaoDTO){
        Avaliacao avaliacao = avaliacaoService.atualizar(id, avaliacaoDTO.newAvaliacao());
        return ResponseEntity.ok().body(AvaliacaoDTO.newAvaliacaoDTO(avaliacao));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        avaliacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
