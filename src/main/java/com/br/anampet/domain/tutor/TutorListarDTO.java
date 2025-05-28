package com.br.anampet.domain.tutor;

import com.br.anampet.domain.usuario.Usuario;
import com.br.anampet.domain.usuario.UsuarioListarDTO;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.Instant;
import java.util.Date;

public record TutorListarDTO(
    Long id,
    String nome,
    String telefone,
    String email,
    Instant data_nascimento,
    Estado estado,
    String cidade,
    String bairro,
    String rua,
    String numero,
    String complemento,
    String observacao,
    UsuarioListarDTO usuario
) {

    public TutorListarDTO(Tutor tutor) {
        this(tutor.getId(), tutor.getNome(), tutor.getTelefone(), tutor.getEmail(), tutor.getData_nascimento(), tutor.getEstado(), tutor.getCidade(), tutor.getBairro(), tutor.getRua(), tutor.getNumero(), tutor.getComplemento(), tutor.getObservacao(), new UsuarioListarDTO(tutor.getUsuario()));
    }

}