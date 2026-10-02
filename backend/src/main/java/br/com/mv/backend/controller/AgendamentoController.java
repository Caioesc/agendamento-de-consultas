package br.com.mv.backend.controller;

import br.com.mv.backend.dto.AgendamentoRequestDTO;
import br.com.mv.backend.service.AgendamentoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService agendamentoService){
        this.service = agendamentoService;
    }

    @PostMapping
    public void cadastrar(AgendamentoRequestDTO agendamento){
    }
}
