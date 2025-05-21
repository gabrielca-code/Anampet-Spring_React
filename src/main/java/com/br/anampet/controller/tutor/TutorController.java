package com.br.anampet.controller.tutor;

import com.br.anampet.domain.tutor.Tutor;
import com.br.anampet.domain.tutor.TutorCadastrarDTO;
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

@RestController
@RequestMapping("tutor")
public class TutorController {

    @Autowired
    private TutorRepository tutorRepository;

    @GetMapping
    public void obterListaTutores() {
        System.out.println("Get Tutores");
    }

    @GetMapping("/{id}")
    public ResponseEntity obterUnicoTutor(@PathVariable Long id) {
        var tutor = tutorRepository.getReferenceById(id);

        return ResponseEntity.ok().body(new TutorListarDTO(tutor));
    }

    @PostMapping
    @Transactional
    public ResponseEntity criarTutor(@RequestBody @Valid TutorCadastrarDTO tutorDto, UriComponentsBuilder uriBuilder) {
        var tutor = new Tutor(tutorDto);
        tutorRepository.save(tutor);

        var uri = uriBuilder.path("tutor/{id}").buildAndExpand(tutor.getId()).toUri();

        return ResponseEntity.created(uri).body(new TutorListarDTO(tutor));
    }

    @PutMapping
    @Transactional
    public void editarTutor() {
        System.out.println("Put Tutor");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirTutor(@PathVariable Long id) {
        tutorRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}