package br.com.mv.backend.controller;

import br.com.mv.backend.dto.AgendamentoRequestDTO;
import br.com.mv.backend.dto.AgendamentoResponseDTO;
import br.com.mv.backend.dto.CancelamentoRequestDTO;
import br.com.mv.backend.enums.StatusAgendamento;
import br.com.mv.backend.service.AgendamentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("agendamentos")
@Tag(name = "Agendamentos", description = "Operações relacionadas a listagem, marcação e cancelamento de agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService agendamentoService){
        this.service = agendamentoService;
    }

    @PostMapping
    public AgendamentoResponseDTO cadastrar(@RequestBody @Valid AgendamentoRequestDTO agendamento){
        AgendamentoResponseDTO response = service.cadastrar(agendamento);
        return response;
    }

    @GetMapping
    public List<AgendamentoResponseDTO> listar(
            @RequestParam(required = false) Long profissionalId,
            @RequestParam(required = false) Long pacienteId,
            @RequestParam(required = false) StatusAgendamento status
    ){
        return service.listar(profissionalId, pacienteId, status);
    }

    @PatchMapping("/cancelar/{id}")
    public AgendamentoResponseDTO cancelar(@PathVariable Long id, @RequestBody @Valid CancelamentoRequestDTO dadosCancelamento){
        return service.cancelar(id, dadosCancelamento);
    }
}
