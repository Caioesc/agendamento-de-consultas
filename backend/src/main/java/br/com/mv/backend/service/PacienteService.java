package br.com.mv.backend.service;

import br.com.mv.backend.dto.PacienteRequestDTO;
import br.com.mv.backend.entity.Paciente;
import br.com.mv.backend.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    // Optei pela injeção por construtor em vez de @Autowired no repository, visando a segurança da imutabilidade.
    public PacienteService(PacienteRepository pacienteRepository){
        this.repository = pacienteRepository;
    }

    @Transactional
    public void cadastrar(PacienteRequestDTO dadosPaciente){
        Paciente paciente = new Paciente(dadosPaciente);
        repository.save(paciente);
    }
}
