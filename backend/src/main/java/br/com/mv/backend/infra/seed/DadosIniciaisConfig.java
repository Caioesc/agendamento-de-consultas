package br.com.mv.backend.infra.seed;

import br.com.mv.backend.entity.Profissional;
import br.com.mv.backend.enums.Especialidade;
import br.com.mv.backend.repository.ProfissionalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DadosIniciaisConfig {

    @Bean
    public CommandLineRunner carregarProfissionais(ProfissionalRepository repository) {
        return args -> {

            if (repository.count() == 0) {
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

                repository.saveAll(List.of(p1, p2, p3, p4));
            }
        };
    }
}
