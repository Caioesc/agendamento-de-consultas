package br.com.mv.backend.service;

import br.com.mv.backend.dto.AgendamentoRequestDTO;
import br.com.mv.backend.dto.AgendamentoResponseDTO;
import br.com.mv.backend.dto.CancelamentoRequestDTO;
import br.com.mv.backend.entity.Agendamento;
import br.com.mv.backend.entity.Paciente;
import br.com.mv.backend.entity.Profissional;
import br.com.mv.backend.enums.StatusAgendamento;
import br.com.mv.backend.infra.exception.RegraDeNegocioException;
import br.com.mv.backend.repository.AgendamentoRepository;
import br.com.mv.backend.repository.PacienteRepository;
import br.com.mv.backend.repository.ProfissionalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final ProfissionalRepository profissionalRepository;
    private final PacienteRepository pacienteRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, ProfissionalRepository profissionalRepository, PacienteRepository pacienteRepository){
        this.agendamentoRepository = agendamentoRepository;
        this.profissionalRepository = profissionalRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @Transactional
    public AgendamentoResponseDTO cadastrar(AgendamentoRequestDTO dadosAgendamento){
        if(agendamentoRepository.existsByProfissionalIdAndDataHora(dadosAgendamento.profissionalId(), dadosAgendamento.dataHora())){
            throw new RegraDeNegocioException("O profissional já possui um agendamento nesse horário");
        }

        Profissional profissional = profissionalRepository.findById(dadosAgendamento.profissionalId()).orElseThrow(
                () -> new RegraDeNegocioException("Profissional não encontrado"));

        Paciente paciente = pacienteRepository.findById(dadosAgendamento.pacienteId()).orElseThrow(
                ()-> new RegraDeNegocioException("Paciente não encontrado"));

        Agendamento agendamento = new Agendamento(profissional, paciente, dadosAgendamento.dataHora(), dadosAgendamento.tipoAtendimento());

        agendamentoRepository.save(agendamento);
        return new AgendamentoResponseDTO(agendamento);
    }

    public List<AgendamentoResponseDTO> listar(Long profissionalId, Long pacienteId, StatusAgendamento statusAgendamento){
        List<Agendamento> agendamentos;
        if(profissionalId != null){
            agendamentos = agendamentoRepository.findByProfissionalId(profissionalId);
        } else if (pacienteId != null) {
            agendamentos = agendamentoRepository.findByPacienteId(pacienteId);
        } else if (statusAgendamento != null) {
            agendamentos = agendamentoRepository.findByStatus(statusAgendamento);
        }else {
            agendamentos = agendamentoRepository.findAll();
        }
        return agendamentos.stream().map(AgendamentoResponseDTO::new).toList();
    }

    @Transactional
    public AgendamentoResponseDTO cancelar(Long id, CancelamentoRequestDTO dadosCancelamento){
        Agendamento agendamento = agendamentoRepository.getReferenceById(id);
        agendamento.cancelar(dadosCancelamento);

        agendamentoRepository.save(agendamento);
        return new AgendamentoResponseDTO(agendamento);
    }


}
