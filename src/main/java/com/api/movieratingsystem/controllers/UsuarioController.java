package com.api.movieratingsystem.controllers;

import com.api.movieratingsystem.models.Usuario;
import com.api.movieratingsystem.services.UsuarioService;
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
@RequestMapping(value = "/usuarios")
@Tag(name = "Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Busca todos os usuarios")
    @GetMapping
    public ResponseEntity<Page<Usuario>> buscarPorTodos(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        Page<Usuario> list = usuarioService.buscarPorTodos(pageable);
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Busca um usuario pelo ID")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok().body(usuario);
    }

    @Operation(summary = "Salva um usuario")
    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        usuario = usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @Operation(summary = "Atualiza o ususario")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario){
        usuario = usuarioService.atualizar(id, usuario);
        return ResponseEntity.ok().body(usuario);
    }
}
