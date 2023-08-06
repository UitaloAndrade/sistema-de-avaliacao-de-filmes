package com.api.movieratingsystem.config;

import com.api.movieratingsystem.models.AvaliacaoModel;
import com.api.movieratingsystem.models.FilmeModel;
import com.api.movieratingsystem.repositories.AvaliacaoRepository;
import com.api.movieratingsystem.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TesteConfiguration implements CommandLineRunner {

    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Override
    public void run(String... args) throws Exception {
        filmeRepository.deleteAll();
        avaliacaoRepository.deleteAll();

        FilmeModel filme1 = new FilmeModel(null, "Harry Potter", "Uitalo", "2001/01/01", "Um filme epico da minha infancia", null, null);
        FilmeModel filme2 = new FilmeModel(null, "Velozes e furiosos", "Uitalo", "2001/01/01", "Melhor filme sobre carros", null, null);
        FilmeModel filme3 = new FilmeModel(null, "Barbie", "Uitalo", "2001/01/01", "Novo no cinema", null, null);
        FilmeModel filme4 = new FilmeModel(null, "Hobbit", "Uitalo", "2001/01/01", "Legal", null, null);

        filmeRepository.save(filme1);
        filmeRepository.save(filme2);
        filmeRepository.save(filme3);
        filmeRepository.save(filme4);

        AvaliacaoModel avaliacao1 = new AvaliacaoModel(null, filme1, 8.7, "um filme muito bom = av1");
        AvaliacaoModel avaliacao2 = new AvaliacaoModel(null, filme1, 9.2, "um filme muito bom = av2");
        AvaliacaoModel avaliacao3 = new AvaliacaoModel(null, filme2, 8.1, "um filme mais ou menos = av3");
        AvaliacaoModel avaliacao4 = new AvaliacaoModel(null, filme3, 10.0, "um filme muito bom = av4");
        AvaliacaoModel avaliacao5 = new AvaliacaoModel(null, filme4, 5.7, "um filme muito bom = av5");

        avaliacaoRepository.save(avaliacao1);
        avaliacaoRepository.save(avaliacao2);
        avaliacaoRepository.save(avaliacao3);
        avaliacaoRepository.save(avaliacao4);
        avaliacaoRepository.save(avaliacao5);
    }
}
