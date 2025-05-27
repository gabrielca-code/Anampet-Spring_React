package com.br.anampet.controller.tutor;

import com.br.anampet.domain.tutor.Tutor;
import com.br.anampet.domain.tutor.TutorCadastrarDTO;
import com.br.anampet.domain.tutor.TutorEditarDTO;
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
        var tutor = tutorRepository.findById(id);
        return tutor.get();
    }

    public Tutor criarTutor(TutorCadastrarDTO tutorDto) {
        return tutorRepository.save(new Tutor(tutorDto));
    }

    public Tutor editarTutor(TutorEditarDTO tutorDto) {
        var tutor = tutorRepository.getReferenceById(tutorDto.id());
        tutor.editarCampos(tutorDto);
        return tutor;
    }

    public void excluirTutor(Long id) {
        tutorRepository.deleteById(id);
    }

}
