package com.br.anampet.controller.usuario;

import com.br.anampet.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;

public record UsuarioListarDTO(
        String nome,
        String crmv,
        String email,
        String login,
        String cpf
) {

    public UsuarioListarDTO(Usuario usuario) {
        this(usuario.getNome(), usuario.getCrmv(), usuario.getEmail(), usuario.getLogin(), usuario.getCpf());
    }

}
