package com.api.movieratingsystem.models.dto;

import com.api.movieratingsystem.models.enums.Perfil;

public record RegistrerDTO(String nome, String email, String senha, Perfil perfil) {
}
