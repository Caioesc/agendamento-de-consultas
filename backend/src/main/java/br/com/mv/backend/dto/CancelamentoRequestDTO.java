package br.com.mv.backend.dto;

import jakarta.validation.constraints.NotBlank;

public record CancelamentoRequestDTO(@NotBlank(message = "O motivo do cancelamento deve ser informado") String motivo) {
}
