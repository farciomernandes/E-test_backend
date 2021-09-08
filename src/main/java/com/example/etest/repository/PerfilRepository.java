package com.example.etest.repository;

import com.example.etest.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    Optional<Perfil> findByNome(String nome);
}
