package br.com.mv.backend.repository;

import br.com.mv.backend.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    //Verificação de agendamento que contenha um profissional e data/hora específicos
    boolean existsByProfissionalIdAndDataHora(Long profissionalId, LocalDateTime dataHora);
}
