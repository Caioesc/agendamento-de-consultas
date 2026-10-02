package br.com.mv.backend.dto;

import br.com.mv.backend.enums.TipoAtendimento;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendamentoRequestDTO(
        @NotNull
        Long pacienteId,

        @NotNull
        Long profissionalId,

        @NotNull
        @FutureOrPresent(message = "O agendamento não pode ser criado em uma data ou hora passada.")
        LocalDateTime dataHora,

        @NotNull
        TipoAtendimento tipoAtendimento) {
}
