package com.br.anampet.controller.tutor;

import com.br.anampet.domain.tutor.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
}
