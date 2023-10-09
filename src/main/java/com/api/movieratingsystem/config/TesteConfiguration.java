package com.api.movieratingsystem.config;

import com.api.movieratingsystem.models.Avaliacao;
import com.api.movieratingsystem.models.Filme;
import com.api.movieratingsystem.models.Usuario;
import com.api.movieratingsystem.repositories.FilmeRepository;
import com.api.movieratingsystem.repositories.UsuarioRepository;
import com.api.movieratingsystem.services.AvaliacaoService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
@AllArgsConstructor
public class TesteConfiguration implements CommandLineRunner {

    private FilmeRepository filmeRepository;
    private AvaliacaoService avaliacaoService;
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {

        Filme filme1 = new Filme("Filme 01", "Diretor 01", "2001/01/01", "Sinopse 01");
        Filme filme2 = new Filme("Filme 02", "Diretor 02", "2001/01/01", "Sinopse 02");

        filmeRepository.saveAll(Arrays.asList(filme1, filme2));

        Usuario usuario1 = new Usuario("Usuario 01");
        Usuario usuario2 = new Usuario("Usuario 02");
        Usuario usuario3 = new Usuario("Usuario 03");

        usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3));

        Avaliacao avaliacao1 = new Avaliacao(filme1, 5, "Avaliacao 01", usuario1);
        Avaliacao avaliacao2 = new Avaliacao(filme1, 5, "Avaliacao 02", usuario1);
        Avaliacao avaliacao3 = new Avaliacao( filme2, 5, "Avaliacao 03", usuario2);
        Avaliacao avaliacao4 = new Avaliacao(filme2, 5, "Avaliacao 04", usuario2);
        Avaliacao avaliacao5 = new Avaliacao(filme1, 5, "Avaliacao 05", usuario3);

        avaliacaoService.salvar(avaliacao1);
        avaliacaoService.salvar(avaliacao2);
        avaliacaoService.salvar(avaliacao3);
        avaliacaoService.salvar(avaliacao4);
        avaliacaoService.salvar(avaliacao5);
    }
}
