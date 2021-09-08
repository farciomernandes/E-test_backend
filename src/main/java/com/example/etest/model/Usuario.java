package com.example.etest.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private List<Perfil> perfis = new ArrayList<>();

    private String nome;
    private String matricula;
    private String senha;

    public Usuario(String nome, String email, String senha, String matricula) {
        this.setName(nome);
        this.setMatricula(email);
        this.setPassword(senha);
        this.setMatricula(matricula);
    }

    public Usuario() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setPassword(String senha) {
        this.senha = senha;
    }

    public List<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.perfis;
    }

    @Override
    public String getPassword() {

        return senha;
    }

    @Override
    public String getUsername() {


        return nome;
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