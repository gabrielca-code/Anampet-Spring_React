package com.br.anampet.controller.tutor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tutor")
public class TutorController {

    @GetMapping
    public void obterListaTutores() {
        System.out.println("Get Tutores");
    }

    @GetMapping("/{id}")
    public void obterUnicoTutor() {
        System.out.println("Get Tutor");
    }

    @PostMapping
    public void criarTutor() {
        System.out.println("Post Tutor");
    }

    @PutMapping
    public void editarTutor() {
        System.out.println("Put Tutor");
    }

    @DeleteMapping
    public void excluirTutor() {
        System.out.println("Delete Tutor");
    }

}