package com.br.anampet.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UsuarioCadastrarDTO(
        @NotBlank(message = "Preencha o campo Nome")
        @Size(min = 5, max = 100, message = "O nome deve ter entre 5 e 100 caracteres")
        String nome,

        @NotBlank(message = "Preencha o campo CRMV")
        @Pattern(regexp = "^\\d{4,6}", message = "O CRMV deve ter entre 4 e 6 caracteres, conforme o formato do documento")
        String crmv,

        @NotBlank(message = "Preencha o campo Email")
        @Email
        @Size(min = 8, message = "O Email deve ter no mínimo 8 caracteres")
        String email,

        @NotBlank(message = "Preencha o campo Login")
        @Size(min = 8, max = 30, message = "O Login deve ter entre 8 e 30 caracteres")
        String login,

        @NotBlank(message = "Preencha o campo Senha")
        @Size(min = 8, max = 30, message = "O Email deve entre 8 e 30 caracteres")
        String senha,

        @NotBlank(message = "Preencha o campo CPF")
        @Pattern(regexp = "^\\d{11}]", message = "O CPF deve ser preenchido com 11 caracteres sem pontos ou hífen")
        String cpf
) {
}
