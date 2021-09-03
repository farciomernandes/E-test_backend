package com.example.etest.controller;


import com.example.etest.controller.dto.ProfessorDTO;
import com.example.etest.controller.form.LoginForm;
import com.example.etest.model.Professor;
import com.example.etest.model.Usuario;
import com.example.etest.repository.AlunoRepository;
import com.example.etest.repository.ProfessorRepository;
import com.example.etest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping()
    public ResponseEntity registerUser(LoginForm form, BindingResult bindingResult) {
        String password = new BCryptPasswordEncoder().encode(form.getSenha());
        form.setSenha(password);

        usuarioRepository.save(new Usuario(form.getNome(), form.getMatricula(), form.getSenha()));

        Professor professor = new Professor(form.getNome(), form.getEmail(), form.getSenha(), form.getMatricula());
        if(form.getTipo().equals("Professor")){
            professorRepository.save(professor);
        }
        return ResponseEntity.ok(ProfessorDTO.converter(professor));
        //if(bindingResult.hasErrors()){
        //    System.out.println("Erro no campo");
        //    return "redirect:/register";
        //}else{
        //    userService.save(user);
        //}

        //return "redirect:/Home";
    }
}
