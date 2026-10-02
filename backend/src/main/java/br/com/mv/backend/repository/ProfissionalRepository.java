package br.com.mv.backend.repository;

import br.com.mv.backend.entity.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
}
