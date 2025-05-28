package com.br.anampet.controller.usuario;

import com.br.anampet.domain.usuario.Usuario;
import com.br.anampet.domain.usuario.UsuarioCadastrarDTO;
import com.br.anampet.domain.usuario.UsuarioEditarDTO;
import com.br.anampet.infra.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> obterUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obterUsuarioUnico(Long id) {
        return buscarUsuarioValidandoNotFound(id);
    }
    public Usuario criarUsuario(UsuarioCadastrarDTO usuarioDto) {
        return usuarioRepository.save(new Usuario(usuarioDto));
    }

    public Usuario editarUsuario(UsuarioEditarDTO usuarioDto) {
        var usuario = buscarUsuarioValidandoNotFound(usuarioDto.id());
        usuario.editarCampos(usuarioDto);

        return usuario;
    }

    public void deletarUsuario(Long id) {
        buscarUsuarioValidandoNotFound(id);
        usuarioRepository.deleteById(id);
    }

    private Usuario buscarUsuarioValidandoNotFound(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

}
