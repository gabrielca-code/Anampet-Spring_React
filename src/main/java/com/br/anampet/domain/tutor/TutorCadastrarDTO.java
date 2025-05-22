package com.br.anampet.domain.tutor;

import com.br.anampet.domain.usuario.Usuario;

import java.util.Date;

public record TutorCadastrarDTO(
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
    String observacao,
    Usuario usuario
) {
}
