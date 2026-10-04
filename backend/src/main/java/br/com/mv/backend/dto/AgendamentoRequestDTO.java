package br.com.mv.backend.dto;

import br.com.mv.backend.enums.TipoAtendimento;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoRequestDTO(
        @NotNull(message = "O paciente deve ser informado")
        Long pacienteId,

        @NotNull(message = "O profissional deve ser informado")
        Long profissionalId,

        @NotNull(message = "A data/hora devem ser informados")
        @FutureOrPresent(message = "O agendamento não pode ser criado em uma data ou hora passada")
        LocalDateTime dataHora,

        @NotNull(message = "O tipo do atendimento deve ser informado")
        TipoAtendimento tipoAtendimento) {
}
