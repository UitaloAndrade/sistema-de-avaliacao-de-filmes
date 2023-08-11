package com.api.movieratingsystem.records;

import com.api.movieratingsystem.models.FilmeModel;

public record AvaliacaoRecord(Long id, FilmeModel filme, Integer nota, String comentario) {
}
