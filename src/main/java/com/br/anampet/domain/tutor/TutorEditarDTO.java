package com.br.anampet.domain.tutor;

import com.br.anampet.domain.usuario.Usuario;
import jakarta.validation.constraints.*;

import java.util.Date;

public record TutorEditarDTO(
        @NotNull
        Long id,

        @Size(min = 8, message = "O nome do tutor deve ter no mínimo 8 caracteres.")
        String nome,

        @Pattern(regexp = "^\\d{10,11}", message = "Telefone deve conter 10 ou 11 dígitos numéricos.")
        String telefone,

        @Email(message = "O email deve ser em um formato válido.")
        String email,
        Date data_nascimento,
        String estado,
        String cidade,
        String bairro,
        String rua,
        String numero,

        @Size(max = 100, message = "O complemento deve ter no máximo 100 caracteres.")
        String complemento,

        @Size(max = 255, message = "A observação deve ter no máximo 255 caracteres.")
        String observacao
) {
}
