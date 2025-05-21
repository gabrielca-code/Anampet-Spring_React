package com.br.anampet.controller.usuario;

import com.br.anampet.domain.usuario.Usuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/{id}")
    public ResponseEntity obterUsuario(@PathVariable Long id) {
        var usuario = usuarioRepository.getReferenceById(id);

        return ResponseEntity.ok().body(new UsuarioListarDTO(usuario));
    }

    @PostMapping
    @Transactional
    public ResponseEntity criarUsuario(@RequestBody @Valid UsuarioCadastrarDTO usuarioDto, UriComponentsBuilder uriBuilder) {
        var usuario = new Usuario(usuarioDto);
        usuarioRepository.save(usuario);

        var uri = uriBuilder.path("usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioListarDTO(usuario));
    }

    @PutMapping
    @Transactional
    public void editarUsuario() {
        System.out.println("Put Usuario");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}