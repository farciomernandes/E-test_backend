package com.example.etest.controller;


import com.example.etest.controller.form.LoginForm;
import com.example.etest.model.Perfil;
import com.example.etest.model.Turma;
import com.example.etest.model.Usuario;
import com.example.etest.repository.PerfilRepository;
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
    PerfilRepository perfilRepository;

    @PostMapping()
    @Transactional
    public ResponseEntity registerUser(@RequestBody LoginForm form, BindingResult bindingResult) {
        String password = new BCryptPasswordEncoder().encode(form.getSenha());
        form.setSenha(password);

        Optional<Usuario> userExist = usuarioRepository.findByMatricula(form.getMatricula());

        if(userExist.isPresent()){
            System.out.println("ELE ENCONTORU UM IGUAL, POR ISSO NÃO CRIOU");
            return ResponseEntity.status(404).body("Já existe um usuário cadastrado com essa matrícula!");
        }
        else{
            System.out.println("ELE NÃO ENCONTORU UM IGUAL, POR ISSO VAI CRIAR");
            Usuario user = usuarioRepository.save(new Usuario(form.getNome(), form.getMatricula(), form.getSenha(), form.getMatricula()));

            if(form.getTipo().equals("Professor")){
                Optional<Perfil> roleProfessor = perfilRepository.findByNome("ROLE_PROFESSOR");
                System.out.println("CHEGOU AQUI" + roleProfessor.get());
                user.getPerfis().addAll(Arrays.asList(roleProfessor.get()));
                System.out.println("VEIO ATE O FIM DO PROFESSOR ");
            }else{
                System.out.println("veio pra role aluno");
                Optional<Perfil> roleAluno = perfilRepository.findByNome("ROLE_ALUNO");
                user.getPerfis().addAll(Arrays.asList(roleAluno.get()));
            }

            return ResponseEntity.ok(user);
        }
    }

    @GetMapping
    public ResponseEntity buscarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarUm(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return ResponseEntity.ok(usuario);
    }
}
