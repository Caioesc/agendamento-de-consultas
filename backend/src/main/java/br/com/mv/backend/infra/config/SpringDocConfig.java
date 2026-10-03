package br.com.mv.backend.infra.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().info(new Info().title("API de gestão de agendamentos")
                .description("API REST para controle de agendamentos, desenvolvida para o teste prático de Desenvolvedor Júnior.")
                .contact(new Contact().name("Caio Escorel Heráclio Lopes Fernandes")
                        .email("caioheraclio@gmail.com")));
    }
}
