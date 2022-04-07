package com.example.etest.controller;


import com.example.etest.config.security.TokenService;
import com.example.etest.controller.dto.AlunoDTO;
import com.example.etest.controller.dto.ProfessorDTO;
import com.example.etest.controller.dto.TokenAlunoDTO;
import com.example.etest.controller.dto.TokenProfessorDTO;
import com.example.etest.controller.form.LoginForm;
import com.example.etest.model.Aluno;
import com.example.etest.model.Professor;
import com.example.etest.model.Usuario;
import com.example.etest.repository.AlunoRepository;
import com.example.etest.repository.ProfessorRepository;
import com.example.etest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public ResponseEntity autenticar(@RequestBody LoginForm form){
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();
        try {
            Authentication authentication = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);
            Optional<Usuario> usuario = usuarioRepository.findByMatricula(form.getMatricula());

            if(usuario.get() instanceof Professor){
                Optional<Professor> professor = professorRepository.findByMatricula(form.getMatricula());

                return ResponseEntity.ok(new TokenProfessorDTO(new ProfessorDTO(professor.get()), token, "Bearer"));
            }
            Optional<Aluno> aluno = alunoRepository.findByMatricula(form.getMatricula());

            return ResponseEntity.ok(new TokenAlunoDTO(new AlunoDTO(aluno.get()), token, "Bearer"));

        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/{token}")
    public ResponseEntity recuperarDados(@PathVariable String token){
        Long idUsuario = tokenService.getIdUsuario(token);

        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);

        if(usuario.get() instanceof Professor){
            Optional<Professor> professor = professorRepository.findById(idUsuario);

            return ResponseEntity.ok(new TokenProfessorDTO(new ProfessorDTO(professor.get()), token, "Bearer"));
        }

        Optional<Aluno> aluno = alunoRepository.findById(idUsuario);
        return ResponseEntity.ok(new TokenAlunoDTO(new AlunoDTO(aluno.get()), token, "Bearer"));

    }
}