package com.api.movieratingsystem.repositories;

import com.api.movieratingsystem.models.AvaliacaoModel;
import com.api.movieratingsystem.models.FilmeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoModel, Long> {
}
