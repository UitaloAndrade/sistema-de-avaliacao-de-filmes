package com.api.movieratingsystem.repositories;

import com.api.movieratingsystem.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}
