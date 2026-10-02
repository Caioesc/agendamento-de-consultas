package br.com.mv.backend.controller;

import br.com.mv.backend.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.mv.backend.dto.PacienteRequestDTO;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService pacienteService){
        this.service = pacienteService;
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid PacienteRequestDTO dados){
        service.cadastrar(dados);
    }
}
