package com.br.anampet.domain.usuario;

public record UsuarioListarDTO(
        Long id,
        String nome,
        String crmv,
        String email,
        String login,
        String cpf
) {

    public UsuarioListarDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getCrmv(), usuario.getEmail(), usuario.getLogin(), usuario.getCpf());
    }

}
