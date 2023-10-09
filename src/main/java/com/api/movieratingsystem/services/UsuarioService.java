package com.api.movieratingsystem.services;

import com.api.movieratingsystem.models.Usuario;
import com.api.movieratingsystem.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public Page<Usuario> buscarPorTodos(Pageable pageable){
        return usuarioRepository.findAll(pageable);
    }

    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id).get();
    }

    @Transactional
    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario atualizar(Long id, Usuario obj){
        Usuario usuario = buscarPorId(id);
        usuario.setNome(obj.getNome());
        return usuarioRepository.save(usuario);
    }
}
