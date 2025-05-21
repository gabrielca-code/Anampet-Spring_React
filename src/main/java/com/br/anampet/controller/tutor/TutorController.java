package com.br.anampet.controller.tutor;

import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
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
    @Transactional
    public void criarTutor() {
        System.out.println("Post Tutor");
    }

    @PutMapping
    @Transactional
    public void editarTutor() {
        System.out.println("Put Tutor");
    }

    @DeleteMapping
    @Transactional
    public void excluirTutor() {
        System.out.println("Delete Tutor");
    }

}