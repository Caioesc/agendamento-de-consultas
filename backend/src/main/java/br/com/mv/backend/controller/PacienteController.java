package br.com.mv.backend.controller;

import br.com.mv.backend.dto.PacienteResponseDTO;
import br.com.mv.backend.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import br.com.mv.backend.dto.PacienteRequestDTO;

import java.util.List;

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

    @GetMapping
    public List<PacienteResponseDTO> listar(){
        return service.listar();
    }
}
