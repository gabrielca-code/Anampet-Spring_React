package com.br.anampet.controller.usuario;

import com.br.anampet.domain.usuario.Usuario;
import com.br.anampet.domain.usuario.UsuarioCadastrarDTO;
import com.br.anampet.domain.usuario.UsuarioListarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario obterUsuarioUnico(Long id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.get();
    }
    public Usuario criarUsuario(UsuarioCadastrarDTO usuarioDto) {
        return usuarioRepository.save(new Usuario(usuarioDto));
    }

    public void editarUsuario() {}

    public void deletarUsuario() {}

}
