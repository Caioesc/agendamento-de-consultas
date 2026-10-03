package br.com.mv.backend.dto;

import br.com.mv.backend.entity.Agendamento;
import br.com.mv.backend.enums.StatusAgendamento;
import br.com.mv.backend.enums.TipoAtendimento;

import java.time.LocalDateTime;

public record AgendamentoResponseDTO(
        Long id,
        String nomePaciente,
        String nomeProfissional,
        LocalDateTime dataHora,
        TipoAtendimento tipoAtendimento,
        StatusAgendamento statusAgendamento
){

    public AgendamentoResponseDTO(Agendamento agendamento){
        this(
                agendamento.getId(),
                agendamento.getPaciente().getNome(),
                agendamento.getProfissional().getNome(),
                agendamento.getDataHora(),
                agendamento.getTipoAtendimento(),
                agendamento.getStatus()
        );
    }

}
