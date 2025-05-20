package com.br.anampet.controller.usuario;

import jakarta.validation.constraints.NotBlank;

public record UsuarioCadastrarDTO(
        @NotBlank
        String nome,
        @NotBlank
        String crmv,
        @NotBlank
        String email,
        @NotBlank
        String login,
        @NotBlank
        String senha,
        @NotBlank
        String cpf
) {
}
