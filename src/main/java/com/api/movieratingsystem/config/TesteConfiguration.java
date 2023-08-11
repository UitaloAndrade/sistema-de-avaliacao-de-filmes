package com.api.movieratingsystem.config;

import com.api.movieratingsystem.models.AvaliacaoModel;
import com.api.movieratingsystem.models.FilmeModel;
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

        FilmeModel filme1 = new FilmeModel("Harry Potter", "Uitalo", "2001/01/01", "Um filme epico da minha infancia");
        FilmeModel filme2 = new FilmeModel("Velozes e furiosos", "Uitalo", "2001/01/01", "Melhor filme sobre carros");
        FilmeModel filme3 = new FilmeModel("Barbie", "Uitalo", "2001/01/01", "Novo no cinema");
        FilmeModel filme4 = new FilmeModel("Hobbit", "Uitalo", "2001/01/01", "Legal");

        AvaliacaoModel avaliacao1 = new AvaliacaoModel(null, filme1, 8, "um filme muito bom = av1");
        AvaliacaoModel avaliacao2 = new AvaliacaoModel(null, filme1, 9, "um filme muito bom = av2");
        AvaliacaoModel avaliacao3 = new AvaliacaoModel(null, filme2, 8, "um filme mais ou menos = av3");
        AvaliacaoModel avaliacao4 = new AvaliacaoModel(null, filme3, 10, "um filme muito bom = av4");
        AvaliacaoModel avaliacao5 = new AvaliacaoModel(null, filme4, 5, "um filme muito bom = av5");

        filme1.getAvaliacoes().add(avaliacao1);
        filme1.getAvaliacoes().add(avaliacao2);
        filme2.getAvaliacoes().add(avaliacao3);
        filme3.getAvaliacoes().add(avaliacao4);
        filme4.getAvaliacoes().add(avaliacao5);

        filmeService.save(filmeService.parseFilmeRecord(filme1));
        filmeService.save(filmeService.parseFilmeRecord(filme2));
        filmeService.save(filmeService.parseFilmeRecord(filme3));
        filmeService.save(filmeService.parseFilmeRecord(filme4));

        avaliacaoService.save(avaliacao1);
        avaliacaoService.save(avaliacao2);
        avaliacaoService.save(avaliacao3);
        avaliacaoService.save(avaliacao4);
        avaliacaoService.save(avaliacao5);
    }
}
