package com.br.anampet.controller.tutor;

import com.br.anampet.domain.tutor.Tutor;
import com.br.anampet.domain.tutor.TutorCadastrarDTO;
import com.br.anampet.domain.tutor.TutorEditarDTO;
import com.br.anampet.infra.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public List<Tutor> obterTutores() {
        return tutorRepository.findAll();
    }

    public Tutor obterTutor(Long id) {
        return buscarTutorValidandoNotFound(id);
    }

    public Tutor criarTutor(TutorCadastrarDTO tutorDto) {
        return tutorRepository.save(new Tutor(tutorDto));
    }

    public Tutor editarTutor(TutorEditarDTO tutorDto) {
        var tutor = buscarTutorValidandoNotFound(tutorDto.id());
        tutor.editarCampos(tutorDto);

        return tutor;
    }

    public void excluirTutor(Long id) {
        buscarTutorValidandoNotFound(id);
        tutorRepository.deleteById(id);
    }

    private Tutor buscarTutorValidandoNotFound (Long id) {
        return tutorRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

}
