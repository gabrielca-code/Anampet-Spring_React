package com.br.anampet.controller.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void obterUsuarioUnico() {}

    public void cadastrarUsuario() {}

    public void editarUsuario() {}

    public void deletarUsuario() {}

}
