package com.api.movieratingsystem.controllers;

import com.api.movieratingsystem.models.usuario.dtos.AunthenticationDTO;
import com.api.movieratingsystem.models.usuario.dtos.LoginResponseDTO;
import com.api.movieratingsystem.models.usuario.dtos.RegistrerDTO;
import com.api.movieratingsystem.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/usuario")
@Tag(name = "Usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Operation(summary = "Endpoint para logar usuario")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AunthenticationDTO data){
        LoginResponseDTO token = usuarioService.login(data);
        return ResponseEntity.ok().body(token);
    }

    @Operation(summary = "Endpoint para cadastrar usuario")
    @PostMapping("/novo")
    public ResponseEntity novo(@RequestBody @Valid RegistrerDTO data){
        usuarioService.novoUsuario(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
