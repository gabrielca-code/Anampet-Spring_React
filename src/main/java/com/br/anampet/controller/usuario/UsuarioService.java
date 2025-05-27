package com.br.anampet.controller.usuario;

import com.br.anampet.domain.usuario.Usuario;
import com.br.anampet.domain.usuario.UsuarioCadastrarDTO;
import com.br.anampet.domain.usuario.UsuarioEditarDTO;
import com.br.anampet.domain.usuario.UsuarioListarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> obterUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obterUsuarioUnico(Long id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.get();
    }
    public Usuario criarUsuario(UsuarioCadastrarDTO usuarioDto) {
        return usuarioRepository.save(new Usuario(usuarioDto));
    }

    public Usuario editarUsuario(UsuarioEditarDTO usuarioDto) {
        var usuario = usuarioRepository.getReferenceById(usuarioDto.id());
        usuario.editarCampos(usuarioDto);
        return usuario;
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
