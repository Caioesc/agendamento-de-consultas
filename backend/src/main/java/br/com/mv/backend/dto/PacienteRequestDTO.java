package br.com.mv.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record PacienteRequestDTO(
        @NotBlank
        String nome,

        @NotBlank
        @CPF(message = "O CPF informado é inválido.")
        String cpf,

        @NotBlank
        @Size(min = 10, max = 11, message = "O telefone deve conter 10 ou 11 números.")
        String telefone,

        @NotBlank
        @Email
        String email) {
}
