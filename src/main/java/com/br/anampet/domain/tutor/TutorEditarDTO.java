package com.br.anampet.domain.tutor;

import com.br.anampet.domain.usuario.Usuario;

import java.util.Date;

public record TutorEditarDTO(
    Long id,
    String nome,
    String telefone,
    String email,
    Date data_nascimento,
    String estado,
    String cidade,
    String bairro,
    String rua,
    String numero,
    String complemento,
    String observacao
) {
}
