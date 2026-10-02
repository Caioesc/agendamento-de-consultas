package br.com.mv.backend.dto;

import br.com.mv.backend.entity.Paciente;

public record PacienteResponseDTO(Long id, String nome, String email) {

    public PacienteResponseDTO(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail());
    }
}
