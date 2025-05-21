package com.br.anampet.controller.usuario;

import com.br.anampet.domain.usuario.Usuario;
import com.br.anampet.domain.usuario.UsuarioCadastrarDTO;
import com.br.anampet.domain.usuario.UsuarioEditarDTO;
import com.br.anampet.domain.usuario.UsuarioListarDTO;
import jakarta.transaction.Transactional;
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
    public ResponseEntity editarUsuario(@RequestBody @Valid UsuarioEditarDTO usuarioDto) {
        var usuario = usuarioRepository.getReferenceById(usuarioDto.id());
        usuario.editarCampos(usuarioDto);

        return ResponseEntity.ok().body(new UsuarioListarDTO(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}