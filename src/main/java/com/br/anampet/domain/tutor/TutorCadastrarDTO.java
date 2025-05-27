package com.br.anampet.domain.tutor;

import com.br.anampet.domain.usuario.Usuario;
import jakarta.validation.constraints.*;

import java.time.Instant;
import java.util.Date;

public record TutorCadastrarDTO(
        @NotBlank(message = "O nome do tutor não pode estar vazio.")
        @Size(min = 8, message = "O nome do tutor deve ter no mínimo 8 caracteres.")
        String nome,

        @Pattern(regexp = "^\\d{10,11}", message = "Telefone deve conter 10 ou 11 dígitos numéricos.")
        String telefone,

        @Email(message = "O email deve ser em um formato válido.")
        String email,

        Instant data_nascimento,

        @NotNull(message = "O estado do tutor deve ser preenchido.")
        Estado estado,

        @NotBlank(message = "A cidade do tutor deve ser preenchido.")
        String cidade,

        @NotBlank(message = "O bairro do tutor deve ser preenchido.")
        String bairro,

        @NotBlank(message = "A rua do tutor deve ser preenchido.")
        String rua,

        @NotBlank(message = "O número do endereço do tutor deve ser preenchido.")
        String numero,

        @Size(max = 100, message = "O complemento deve ter no máximo 100 caracteres.")
        String complemento,

        @Size(max = 255, message = "A observação deve ter no máximo 255 caracteres.")
        String observacao,

        @NotNull(message = "O usuário deve ser preenchido.")
        Usuario usuario
) {
}
