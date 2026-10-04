package br.com.mv.backend.controller;

import br.com.mv.backend.dto.PacienteResponseDTO;
import br.com.mv.backend.service.PacienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import br.com.mv.backend.dto.PacienteRequestDTO;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("pacientes")
@Tag(name = "Pacientes", description = "Operações relacionadas ao cadastro e listagem de pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService pacienteService){
        this.service = pacienteService;
    }

    @PostMapping
    public PacienteResponseDTO cadastrar(@RequestBody @Valid PacienteRequestDTO dados){
        return service.cadastrar(dados);
    }

    @GetMapping
    public List<PacienteResponseDTO> listar(){
        return service.listar();
    }
}
