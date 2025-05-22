package com.br.anampet.domain.tutor;

import com.br.anampet.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "tutor")
@Table(name = "tutores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String telefone;
    private String email;
    private Date data_nascimento;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;
    private String observacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    public Tutor(TutorCadastrarDTO tutorDto) {
        this.nome = tutorDto.nome();
        this.telefone = tutorDto.telefone();
        this.email = tutorDto.email();
        this.data_nascimento = tutorDto.data_nascimento();
        this.estado = tutorDto.estado();
        this.cidade = tutorDto.cidade();
        this.bairro = tutorDto.bairro();
        this.rua = tutorDto.rua();
        this.numero = tutorDto.numero();
        this.complemento = tutorDto.complemento();
        this.usuario = tutorDto.usuario();
    }

    public void editarCampos(TutorEditarDTO tutorDto) {
        if(tutorDto.nome() != null)
            this.nome = tutorDto.nome();
        if(tutorDto.telefone() != null)
            this.telefone = tutorDto.telefone();
        if(tutorDto.email() != null)
            this.email = tutorDto.email();
        if(tutorDto.data_nascimento() != null)
            this.data_nascimento = tutorDto.data_nascimento();
        if(tutorDto.estado() != null)
            this.estado = tutorDto.estado();
        if(tutorDto.cidade() != null)
            this.cidade = tutorDto.cidade();
        if(tutorDto.bairro() != null)
            this.bairro = tutorDto.bairro();
        if(tutorDto.rua() != null)
            this.rua = tutorDto.rua();
        if(tutorDto.numero() != null)
            this.numero = tutorDto.numero();
        if(tutorDto.complemento() != null)
            this.complemento = tutorDto.complemento();
    }
}