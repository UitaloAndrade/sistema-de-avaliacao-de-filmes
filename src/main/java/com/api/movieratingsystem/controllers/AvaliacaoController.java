package com.api.movieratingsystem.controllers;

import com.api.movieratingsystem.models.Avaliacao;
import com.api.movieratingsystem.models.dto.AvaliacaoDTO;
import com.api.movieratingsystem.models.dto.AvaliacaoRespostaDTO;
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
    public ResponseEntity<List<AvaliacaoRespostaDTO>> buscarTodos(){
        List<Avaliacao> avaliacoes = avaliacaoService.buscarTodos();
        List<AvaliacaoRespostaDTO> avaliacaoRespostaDTO = avaliacoes.stream().map(AvaliacaoRespostaDTO::new).toList();
        return ResponseEntity.ok().body(avaliacaoRespostaDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoRespostaDTO> buscarPorId(@PathVariable Long id){
        Avaliacao avaliacao = avaliacaoService.buscarPorId(id);
        return ResponseEntity.ok().body(new AvaliacaoRespostaDTO(avaliacao));
    }

    @GetMapping(value = "/filme/{id}")
    public ResponseEntity<List<AvaliacaoRespostaDTO>> buscarPorFilme(@PathVariable Long id){
        List<Avaliacao> avaliacoes = avaliacaoService.buscarPorFilme(id);
        List<AvaliacaoRespostaDTO> avaliacaoRespostaDTO = avaliacoes.stream().map(AvaliacaoRespostaDTO::new).toList();
        return ResponseEntity.ok().body(avaliacaoRespostaDTO);
    }
    @GetMapping(value = "/usuario/{id}")
    public ResponseEntity<List<AvaliacaoRespostaDTO>> buscarPorUsuario(@PathVariable Long id){
        List<Avaliacao> avaliacoes = avaliacaoService.buscarPorUsuario(id);
        List<AvaliacaoRespostaDTO> avaliacaoRespostaDTO = avaliacoes.stream().map(AvaliacaoRespostaDTO::new).toList();
        return ResponseEntity.ok().body(avaliacaoRespostaDTO);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoRespostaDTO> salvar(@RequestBody AvaliacaoDTO avaliacaoDTO){
        Avaliacao avaliacao = avaliacaoService.salvar(new Avaliacao(avaliacaoDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(new AvaliacaoRespostaDTO(avaliacao));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoRespostaDTO> atualizar(@PathVariable Long id, @RequestBody AvaliacaoDTO avaliacaoDTO){
        Avaliacao avaliacao = avaliacaoService.atualizar(id, new Avaliacao(avaliacaoDTO));
        return ResponseEntity.ok().body(new AvaliacaoRespostaDTO(avaliacao));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        avaliacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
