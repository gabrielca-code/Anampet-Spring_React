package com.br.anampet.controller.usuario;

import com.br.anampet.domain.usuario.UsuarioCadastrarDTO;
import com.br.anampet.domain.usuario.UsuarioEditarDTO;
import com.br.anampet.domain.usuario.UsuarioListarDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List> obterUsuarios() {
        var listaUsuarios = usuarioService.obterUsuarios();
        return ResponseEntity.ok().body(listaUsuarios.stream().map(UsuarioListarDTO::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity obterUsuario(@PathVariable Long id) {
        var usuario = usuarioService.obterUsuarioUnico(id);

        return ResponseEntity.ok().body(new UsuarioListarDTO(usuario));
    }

    @PostMapping
    @Transactional
    public ResponseEntity criarUsuario(@RequestBody @Valid UsuarioCadastrarDTO usuarioDto, UriComponentsBuilder uriBuilder) {
        var usuario = usuarioService.criarUsuario(usuarioDto);
        var uri = uriBuilder.path("usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioListarDTO(usuario));
    }

    @PutMapping
    @Transactional
    public ResponseEntity editarUsuario(@RequestBody @Valid UsuarioEditarDTO usuarioDto) {
        var usuario = usuarioService.editarUsuario(usuarioDto);

        return ResponseEntity.ok().body(new UsuarioListarDTO(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);

        return ResponseEntity.noContent().build();
    }

}