package com.api.movieratingsystem.models.usuario.dtos;

import com.api.movieratingsystem.models.usuario.enums.Perfil;

public record RegistrerDTO(String nome, String email, String senha, Perfil perfil) {
}
