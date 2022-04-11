package com.example.etest.repository;

import com.example.etest.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface TurmaRepository extends JpaRepository<Turma, Long> {

    Optional<Turma> findByNome(String nome);

//    @Query("SELECT t FROM Turma t JOIN t.professor p WHERE p.id = :id")
//    List<Turma> odfodkkokg(@Param("id") Long id);
    List<Turma> findAllByProfessor(Long id);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM turma_aluno " +
            "WHERE turma_id = :turmaId AND aluno_id = " +
            "ALL(SELECT id FROM usuario WHERE matricula = :matricula)")
    void deleteAlunoFromTurmaByMatricula(@Param("turmaId") Long turmaId, @Param("matricula") String matricula);
}
