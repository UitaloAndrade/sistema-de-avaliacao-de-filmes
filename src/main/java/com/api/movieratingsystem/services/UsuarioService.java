package com.api.movieratingsystem.services;

import com.api.movieratingsystem.config.security.Token;
import com.api.movieratingsystem.models.usuario.Usuario;
import com.api.movieratingsystem.models.usuario.dtos.AunthenticationDTO;
import com.api.movieratingsystem.models.usuario.dtos.LoginResponseDTO;
import com.api.movieratingsystem.models.usuario.dtos.RegistrerDTO;
import com.api.movieratingsystem.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioRepository repository;
    @Autowired
    private Token tokenService;

    public void novoUsuario(RegistrerDTO data) {
        String encryptedPassowrd = new BCryptPasswordEncoder().encode(data.senha());
        Usuario usuario = new Usuario(data.nome(), data.email(), encryptedPassowrd, data.perfil());
        this.repository.save(usuario);
    }

    public LoginResponseDTO login(AunthenticationDTO data) {

        var userNamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = authenticationManager.authenticate(userNamePassword);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return new LoginResponseDTO(token);
    }
}
