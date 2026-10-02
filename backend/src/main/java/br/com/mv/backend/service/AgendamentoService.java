package br.com.mv.backend.service;

import br.com.mv.backend.dto.AgendamentoRequestDTO;
import br.com.mv.backend.entity.Agendamento;
import br.com.mv.backend.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository){
        this.repository = agendamentoRepository;
    }


}
