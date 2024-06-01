package com.api.movieratingsystem.models;

import com.api.movieratingsystem.models.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
@NoArgsConstructor
@Getter @Setter
public class Usuario implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;
    private String senha;
    private Perfil perfil;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Usuario(String nome, String email, String senha, Perfil perfil){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.perfil == Perfil.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
