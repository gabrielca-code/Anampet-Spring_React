package com.br.anampet.domain.usuario;

import com.br.anampet.domain.tutor.Tutor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "usuario")
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario implements Serializable {

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

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Tutor> tutores = new ArrayList<Tutor>();

    public Usuario(UsuarioCadastrarDTO usuarioDto) {
        this.nome = usuarioDto.nome();
        this.crmv = usuarioDto.crmv();
        this.email = usuarioDto.email();
        this.login = usuarioDto.login();
        this.senha = usuarioDto.senha();
        this.cpf = usuarioDto.cpf();
    }

    public void editarCampos(UsuarioEditarDTO usuarioDto) {
        if(usuarioDto.nome() != null)
            this.nome = usuarioDto.nome();
        if(usuarioDto.crmv() != null)
            this.crmv = usuarioDto.crmv();
        if(usuarioDto.email() != null)
            this.email = usuarioDto.email();
        if(usuarioDto.cpf() != null)
            this.cpf = usuarioDto.cpf();
        if(usuarioDto.login() != null)
            this.login = usuarioDto.login();
        if(usuarioDto.senha() != null)
            this.senha = usuarioDto.senha();
    }
}