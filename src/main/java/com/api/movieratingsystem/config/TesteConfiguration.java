package com.api.movieratingsystem.config;

import com.api.movieratingsystem.models.Avaliacao;
import com.api.movieratingsystem.models.Filme;
import com.api.movieratingsystem.services.AvaliacaoService;
import com.api.movieratingsystem.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TesteConfiguration implements CommandLineRunner {

    @Autowired
    private FilmeService filmeService;
    @Autowired
    private AvaliacaoService avaliacaoService;
    @Override
    public void run(String... args) throws Exception {

        Filme filme1 = new Filme("Harry Potter", "Uitalo", "2001/01/01", "Um filme epico da minha infancia");
        Filme filme2 = new Filme("Velozes e furiosos", "Uitalo", "2001/01/01", "Melhor filme sobre carros");

        filmeService.save(filme1);
        filmeService.save(filme2);

        Avaliacao avaliacao1 = new Avaliacao(null, filme1, 8, "um filme muito bom = av1");
        Avaliacao avaliacao2 = new Avaliacao(null, filme1, 9, "um filme muito bom = av2");
        Avaliacao avaliacao3 = new Avaliacao(null, filme2, 8, "um filme mais ou menos = av3");
        Avaliacao avaliacao4 = new Avaliacao(null, filme2, 10, "um filme muito bom = av4");
        Avaliacao avaliacao5 = new Avaliacao(null, filme1, 5, "um filme muito bom = av5");

        avaliacaoService.salvar(avaliacao1);
        avaliacaoService.salvar(avaliacao2);
        avaliacaoService.salvar(avaliacao3);
        avaliacaoService.salvar(avaliacao4);
        avaliacaoService.salvar(avaliacao5);
    }
}
