package com.br.anampet.domain.usuario;

import jakarta.validation.constraints.*;

public record UsuarioEditarDTO(
        @NotNull
        Long id,

        @Size(min = 5, max = 100, message = "O nome deve ter entre 5 e 100 caracteres")
        String nome,

        @Pattern(regexp = "^\\d{4,6}", message = "O CRMV deve ter entre 4 e 6 caracteres, conforme o formato do documento")
        String crmv,

        @Email
        @Size(min = 8, message = "O Email deve ter no mínimo 8 caracteres")
        String email,

        @Size(min = 8, max = 30, message = "O Login deve ter entre 8 e 30 caracteres")
        String login,

        @Size(min = 8, max = 30, message = "O Email deve entre 8 e 30 caracteres")
        String senha,

        @Pattern(regexp = "^\\d{11}", message = "O CPF deve ser preenchido com 11 caracteres sem pontos ou hífen")
        String cpf
) {
}
