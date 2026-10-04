package br.com.mv.backend.repository;

import br.com.mv.backend.entity.Agendamento;
import br.com.mv.backend.enums.StatusAgendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    //Verificação de agendamento que contenha um profissional e data/hora específicos
    boolean existsByProfissionalIdAndDataHora(Long profissionalId, LocalDateTime dataHora);

    //Filtros por profissional, paciente e status
    List<Agendamento> findByProfissionalId(Long profissionalId);
    List<Agendamento> findByPacienteId(Long pacienteId);
    List<Agendamento> findByStatus(StatusAgendamento status);

    List<Agendamento> findByPacienteIdAndProfissionalId(Long pacienteId, Long profissionalId);
    List<Agendamento> findByPacienteIdAndStatus(Long pacienteId, StatusAgendamento status);
    List<Agendamento> findByProfissionalIdAndStatus(Long profissionalId, StatusAgendamento status);

    List<Agendamento> findByPacienteIdAndProfissionalIdAndStatus(Long pacienteId, Long profissionalId, StatusAgendamento status);
}
