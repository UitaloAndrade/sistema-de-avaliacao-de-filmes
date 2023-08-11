package com.api.movieratingsystem.config;

import com.api.movieratingsystem.models.AvaliacaoModel;
import com.api.movieratingsystem.models.FilmeModel;
import com.api.movieratingsystem.repositories.AvaliacaoRepository;
import com.api.movieratingsystem.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TesteConfiguration implements CommandLineRunner {

    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    @Override
    public void run(String... args) throws Exception {

        FilmeModel filme1 = new FilmeModel("Harry Potter", "Uitalo", "2001/01/01", "Um filme epico da minha infancia");
        FilmeModel filme2 = new FilmeModel("Velozes e furiosos", "Uitalo", "2001/01/01", "Melhor filme sobre carros");

        filmeRepository.saveAll(Arrays.asList(filme1, filme2));

        AvaliacaoModel avaliacao1 = new AvaliacaoModel(null, filme1, 8, "um filme muito bom = av1");
        AvaliacaoModel avaliacao2 = new AvaliacaoModel(null, filme1, 9, "um filme muito bom = av2");
        AvaliacaoModel avaliacao3 = new AvaliacaoModel(null, filme2, 8, "um filme mais ou menos = av3");
        AvaliacaoModel avaliacao4 = new AvaliacaoModel(null, filme2, 10, "um filme muito bom = av4");
        AvaliacaoModel avaliacao5 = new AvaliacaoModel(null, filme1, 5, "um filme muito bom = av5");

        avaliacaoRepository.saveAll(Arrays.asList(avaliacao1, avaliacao2, avaliacao3, avaliacao4, avaliacao5));

        filme1.getAvaliacoes().addAll(Arrays.asList(avaliacao1, avaliacao2, avaliacao5));
        filme2.getAvaliacoes().addAll(Arrays.asList(avaliacao3, avaliacao4));

        filme1.setNotaMedia(calcularNotaMedia(filme1.getAvaliacoes()));
        filme2.setNotaMedia(calcularNotaMedia(filme2.getAvaliacoes()));

        filmeRepository.saveAll(Arrays.asList(filme1, filme2));
    }
    private double calcularNotaMedia(List<AvaliacaoModel> avaliacoes){
        if (avaliacoes.isEmpty()) {
            return 0d;
        }
        double somaNotas = avaliacoes.stream().mapToInt(AvaliacaoModel::getNota).sum();
        return somaNotas / avaliacoes.size();
    }
}
