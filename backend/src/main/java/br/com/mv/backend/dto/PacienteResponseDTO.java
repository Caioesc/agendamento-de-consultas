package br.com.mv.backend.dto;

import br.com.mv.backend.entity.Paciente;

public record PacienteResponseDTO(String nome, String email) {

    public PacienteResponseDTO(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail());
    }
}
