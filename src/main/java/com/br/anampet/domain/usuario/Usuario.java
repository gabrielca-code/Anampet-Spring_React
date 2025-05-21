package com.br.anampet.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "usuario")
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    @Column(unique = true)
    private String crmv;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String login;
    private String senha;

    public Usuario(UsuarioCadastrarDTO usuarioDto) {
        this.nome = usuarioDto.nome();
        this.crmv = usuarioDto.crmv();
        this.email = usuarioDto.email();
        this.login = usuarioDto.login();
        this.senha = usuarioDto.senha();
        this.cpf = usuarioDto.cpf();
    }

    public void editarCampos(UsuarioEditarDTO usuarioDto) {
        if(!usuarioDto.nome().isBlank())
            this.nome = usuarioDto.nome();
        if(!usuarioDto.crmv().isBlank())
            this.crmv = usuarioDto.crmv();
        if(!usuarioDto.email().isBlank())
            this.email = usuarioDto.email();
        if(!usuarioDto.cpf().isBlank())
            this.cpf = usuarioDto.cpf();
        if(!usuarioDto.login().isBlank())
            this.login = usuarioDto.login();
        if(!usuarioDto.senha().isBlank())
            this.senha = usuarioDto.senha();
    }
}