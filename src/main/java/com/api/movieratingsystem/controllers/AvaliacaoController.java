package com.api.movieratingsystem.controllers;

import com.api.movieratingsystem.models.Avaliacao;
import com.api.movieratingsystem.models.dto.AvaliacaoDTO;
import com.api.movieratingsystem.models.dto.AvaliacaoRespostaDTO;
import com.api.movieratingsystem.services.AvaliacaoService;
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

import java.util.List;

@Controller
@RequestMapping(value = "/avaliacoes")
@Tag(name = "Avaliação")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @Operation(summary = "Busca todas as avaliações")
    @GetMapping
    public ResponseEntity<Page<AvaliacaoRespostaDTO>> buscarTodos(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Avaliacao> avaliacoes = avaliacaoService.buscarTodos(pageable);
        return ResponseEntity.ok().body(avaliacoes.map(AvaliacaoRespostaDTO::new));
    }

    @Operation(summary = "Busca uma avaliação por ID")
    @GetMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoRespostaDTO> buscarPorId(@PathVariable Long id) {
        Avaliacao avaliacao = avaliacaoService.buscarPorId(id);
        return ResponseEntity.ok().body(new AvaliacaoRespostaDTO(avaliacao));
    }

    @Operation(summary = "Busca as avaliações de um filme")
    @GetMapping(value = "/filme/{id}")
    public ResponseEntity<List<AvaliacaoRespostaDTO>> buscarPorFilme(@PathVariable Long id) {
        List<Avaliacao> avaliacoes = avaliacaoService.buscarPorFilme(id);
        List<AvaliacaoRespostaDTO> avaliacaoRespostaDTO = avaliacoes.stream().map(AvaliacaoRespostaDTO::new).toList();
        return ResponseEntity.ok().body(avaliacaoRespostaDTO);
    }

    @Operation(summary = "Busca as avaliações de um usuario")
    @GetMapping(value = "/usuario/{id}")
    public ResponseEntity<List<AvaliacaoRespostaDTO>> buscarPorUsuario(@PathVariable Long id) {
        List<Avaliacao> avaliacoes = avaliacaoService.buscarPorUsuario(id);
        List<AvaliacaoRespostaDTO> avaliacaoRespostaDTO = avaliacoes.stream().map(AvaliacaoRespostaDTO::new).toList();
        return ResponseEntity.ok().body(avaliacaoRespostaDTO);
    }

    @Operation(summary = "Salva uma avaliação")
    @PostMapping
    public ResponseEntity<AvaliacaoRespostaDTO> salvar(@RequestBody AvaliacaoDTO avaliacaoDTO) {
        Avaliacao avaliacao = avaliacaoService.salvar(new Avaliacao(avaliacaoDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(new AvaliacaoRespostaDTO(avaliacao));
    }

    @Operation(summary = "Atualiza a avaliação")
    @PutMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoRespostaDTO> atualizar(@PathVariable Long id, @RequestBody AvaliacaoDTO avaliacaoDTO) {
        Avaliacao avaliacao = avaliacaoService.atualizar(id, new Avaliacao(avaliacaoDTO));
        return ResponseEntity.ok().body(new AvaliacaoRespostaDTO(avaliacao));
    }

    @Operation(summary = "Deleta a avaliação")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        avaliacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
