package com.br.anampet.controller.usuario;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @GetMapping
    public void obterUsuario() {
        System.out.println("Get Usuario");
    }

    @PostMapping
    public void criarUsuario() {
        System.out.println("Post Usuario");
    }

    @PutMapping
    public void editarUsuario() {
        System.out.println("Put Usuario");
    }

    @DeleteMapping
    public void excluirUsuario() {
        System.out.println("Delete Usuario");
    }

}