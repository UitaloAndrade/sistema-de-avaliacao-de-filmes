package com.api.movieratingsystem.config;

import com.api.movieratingsystem.models.Avaliacao;
import com.api.movieratingsystem.models.Filme;
import com.api.movieratingsystem.models.Usuario;
import com.api.movieratingsystem.repositories.FilmeRepository;
import com.api.movieratingsystem.repositories.UsuarioRepository;
import com.api.movieratingsystem.services.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfiguration implements CommandLineRunner {

    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private AvaliacaoService avaliacaoService;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public void run(String... args) throws Exception {

        Filme filme1 = new Filme("Harry Potter", "Uitalo", "2001/01/01", "Um filme epico da minha infancia");
        Filme filme2 = new Filme("Velozes e furiosos", "Uitalo", "2001/01/01", "Melhor filme sobre carros");

        filmeRepository.saveAll(Arrays.asList(filme1, filme2));

        Usuario usuario1 = new Usuario("Fernando");
        Usuario usuario2 = new Usuario("Pedro");
        Usuario usuario3 = new Usuario("Joao");

        usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3));

        Avaliacao avaliacao1 = new Avaliacao(filme1, 8, "um filme muito bom = av1", usuario1);
        Avaliacao avaliacao2 = new Avaliacao(filme1, 9, "um filme muito bom = av2", usuario1);
        Avaliacao avaliacao3 = new Avaliacao( filme2, 8, "um filme mais ou menos = av3", usuario2);
        Avaliacao avaliacao4 = new Avaliacao(filme2, 10, "um filme muito bom = av4", usuario2);
        Avaliacao avaliacao5 = new Avaliacao(filme1, 5, "um filme muito bom = av5", usuario3);

        avaliacaoService.salvar(avaliacao1);
        avaliacaoService.salvar(avaliacao2);
        avaliacaoService.salvar(avaliacao3);
        avaliacaoService.salvar(avaliacao4);
        avaliacaoService.salvar(avaliacao5);
    }
}
