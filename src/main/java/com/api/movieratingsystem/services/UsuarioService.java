package com.api.movieratingsystem.services;

import com.api.movieratingsystem.models.Usuario;
import com.api.movieratingsystem.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> buscarPorTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id).get();
    }

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario obj){
        Usuario usuario = buscarPorId(id);
        usuario.setNome(obj.getNome());
        return usuarioRepository.save(usuario);
    }
}