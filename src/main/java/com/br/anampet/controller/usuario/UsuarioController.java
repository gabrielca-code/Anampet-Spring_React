package com.br.anampet.controller.usuario;

import com.br.anampet.domain.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public void obterUsuario() {
        System.out.println("Get Usuario");
    }

    @PostMapping
    public ResponseEntity criarUsuario(@RequestBody @Valid UsuarioCadastrarDTO usuarioDto, UriComponentsBuilder uriBuilder) {
        var usuario = new Usuario(usuarioDto);
        usuarioRepository.save(usuario);

        var uri = uriBuilder.path("usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario); //criar DTO
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