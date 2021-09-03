package com.example.etest.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.Collection;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;
    private String matricula;
    private String senha;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    private List<Perfil> perfils;


    public Usuario(String nome, String email, String senha) {
        this.setName(nome);
        this.setMatricula(email);
        this.setPassword(senha);
    }

    public Usuario() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.perfils;
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

    public List<Perfil> getPerfils() {
        return perfils;
    }

    public void setPerfils(List<Perfil> perfils) {
        this.perfils = perfils;
    }
}