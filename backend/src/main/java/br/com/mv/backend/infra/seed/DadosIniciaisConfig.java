package br.com.mv.backend.infra.seed;

import br.com.mv.backend.entity.Agendamento;
import br.com.mv.backend.entity.Paciente;
import br.com.mv.backend.entity.Profissional;
import br.com.mv.backend.enums.Especialidade;
import br.com.mv.backend.enums.StatusAgendamento;
import br.com.mv.backend.enums.TipoAtendimento;
import br.com.mv.backend.repository.AgendamentoRepository;
import br.com.mv.backend.repository.PacienteRepository;
import br.com.mv.backend.repository.ProfissionalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DadosIniciaisConfig {

    @Bean
    public CommandLineRunner carregarProfissionais(ProfissionalRepository profissionalRepository,PacienteRepository pacienteRepository,AgendamentoRepository agendamentoRepository) {
        return args -> {

            if (profissionalRepository.count() == 0) {
                Profissional p1 = new Profissional();
                p1.setNome("Dr. João Silva");
                p1.setEspecialidade(Especialidade.CARDIOLOGIA);

                Profissional p2 = new Profissional();
                p2.setNome("Dra. Ana Costa");
                p2.setEspecialidade(Especialidade.DERMATOLOGIA);

                Profissional p3 = new Profissional();
                p3.setNome("Dra. Juliana Alves");
                p3.setEspecialidade(Especialidade.GINECOLOGIA);

                Profissional p4 = new Profissional();
                p4.setNome("Dr. Carlos Neto");
                p4.setEspecialidade(Especialidade.ORTOPEDIA);

                profissionalRepository.saveAll(List.of(p1, p2, p3, p4));
            }

            if (pacienteRepository.count() == 0) {
                Paciente pac1 = new Paciente();
                pac1.setNome("Maria Oliveira");
                pac1.setCpf("19729535086");
                pac1.setTelefone("81999999999");
                pac1.setEmail("maria@email.com");

                Paciente pac2 = new Paciente();
                pac2.setNome("Pedro Santos");
                pac2.setCpf("67384513006");
                pac2.setTelefone("81988888888");
                pac2.setEmail("pedro@email.com");

                pacienteRepository.saveAll(List.of(pac1, pac2));
            }

            if (agendamentoRepository.count() == 0) {
                List<Profissional> profissionais = profissionalRepository.findAll();
                List<Paciente> pacientes = pacienteRepository.findAll();

                if (!profissionais.isEmpty() && !pacientes.isEmpty()) {
                    Agendamento a1 = new Agendamento();
                    a1.setPaciente(pacientes.get(0));
                    a1.setProfissional(profissionais.get(0));
                    a1.setDataHora(LocalDateTime.now().plusDays(2).withHour(10).withMinute(0).withSecond(0));
                    a1.setTipoAtendimento(TipoAtendimento.EXAME);
                    a1.setStatus(StatusAgendamento.AGENDADO);

                    Agendamento a2 = new Agendamento();
                    a2.setPaciente(pacientes.get(1));
                    a2.setProfissional(profissionais.get(1));
                    a2.setDataHora(LocalDateTime.now().plusDays(3).withHour(14).withMinute(30).withSecond(0));
                    a2.setTipoAtendimento(TipoAtendimento.CONSULTA);
                    a2.setStatus(StatusAgendamento.AGENDADO);

                    agendamentoRepository.saveAll(List.of(a1, a2));
                }
            }
        };
    }
}
