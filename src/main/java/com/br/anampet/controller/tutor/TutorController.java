package com.br.anampet.controller.tutor;

import com.br.anampet.domain.tutor.Tutor;
import com.br.anampet.domain.tutor.TutorCadastrarDTO;
import com.br.anampet.domain.tutor.TutorEditarDTO;
import com.br.anampet.domain.tutor.TutorListarDTO;
import com.br.anampet.domain.usuario.UsuarioListarDTO;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("tutor")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping
    public ResponseEntity<List> obterListaTutores() {
        return ResponseEntity.ok().body(tutorService.obterTutores().stream().map(TutorListarDTO::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity obterUnicoTutor(@PathVariable Long id) {
        var tutor = tutorService.obterTutor(id);

        return ResponseEntity.ok().body(new TutorListarDTO(tutor));
    }

    @PostMapping
    @Transactional
    public ResponseEntity criarTutor(@RequestBody @Valid TutorCadastrarDTO tutorDto, UriComponentsBuilder uriBuilder) {
        var tutor = tutorService.criarTutor(tutorDto);
        var uri = uriBuilder.path("tutor/{id}").buildAndExpand(tutor.getId()).toUri();

        return ResponseEntity.created(uri).body(new TutorListarDTO(tutor));
    }

    @PutMapping
    @Transactional
    public ResponseEntity editarTutor(@RequestBody @Valid TutorEditarDTO tutorDto) {
        var tutor = tutorService.editarTutor(tutorDto);

        return ResponseEntity.ok().body(new TutorListarDTO(tutor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirTutor(@PathVariable Long id) {
        tutorService.excluirTutor(id);

        return ResponseEntity.noContent().build();
    }

}