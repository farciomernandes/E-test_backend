package com.example.etest.controller;


import com.example.etest.controller.dto.ProfessorDTO;
import com.example.etest.controller.form.LoginForm;
import com.example.etest.controller.form.AtualizarUsuarioForm;
import com.example.etest.model.Aluno;
import com.example.etest.model.Perfil;
import com.example.etest.model.Professor;
import com.example.etest.model.Usuario;
import com.example.etest.repository.PerfilRepository;
import com.example.etest.repository.ProfessorRepository;
import com.example.etest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    PerfilRepository perfilRepository;

    @PostMapping()
    @Transactional
    public ResponseEntity registerUser(@RequestBody LoginForm form, BindingResult bindingResult) {
        String password = new BCryptPasswordEncoder().encode(form.getSenha());
        form.setSenha(password);

        Optional<Usuario> userExist = usuarioRepository.findByMatricula(form.getMatricula());
        Usuario user;

        if(userExist.isPresent()){
            return ResponseEntity.status(404).body("Já existe um usuário cadastrado com essa matrícula!");
        }
        else{
            if(form.getTipo().equals("Professor")){
                user = new Professor(form.getNome(), form.getEmail(), form.getSenha(), form.getMatricula());
                usuarioRepository.save(user);

                Optional<Perfil> roleProfessor = perfilRepository.findByNome("ROLE_PROFESSOR");

                user.getPerfis().addAll(Arrays.asList(roleProfessor.get()));

            }else{

                user = new Aluno(form.getNome(), form.getEmail(), form.getSenha(), form.getMatricula());
                usuarioRepository.save(user);

                Optional<Perfil> roleAluno = perfilRepository.findByNome("ROLE_ALUNO");
                user.getPerfis().addAll(Arrays.asList(roleAluno.get()));
                return ResponseEntity.ok(user);
            }
            return ResponseEntity.ok(user);
        }
    }


    @GetMapping("/professor")
    public List<ProfessorDTO> buscarTodos() {
        List<Professor> usuarios = professorRepository.findAll();
        return ProfessorDTO.converter(usuarios);
    }

    @GetMapping("/professor/{id}")
    public ResponseEntity buscarUm(@PathVariable Long id) {
        Optional<Professor> usuario = professorRepository.findById(id);
        return ResponseEntity.ok(new ProfessorDTO(usuario.get()));
    }

    @PutMapping ("/{id}")//Configurar front-end paara enviar todos os dados
    @Transactional
    public ResponseEntity atualizar(@RequestBody AtualizarUsuarioForm form, @PathVariable Long id) {
        Optional<Usuario> user = usuarioRepository.findById(id);
        String password = new BCryptPasswordEncoder().encode(form.getSenha());

        user.get().setName(form.getNome());
        user.get().setPassword(password);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    @Transactional //Essa tag avisa que as alterações feitas na classe local devem ser feitas no banco de dados também
    public ResponseEntity remover(@PathVariable Long id){
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if(optional.isPresent()){
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
