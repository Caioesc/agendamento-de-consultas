package br.com.mv.backend.controller;

import br.com.mv.backend.dto.AgendamentoRequestDTO;
import br.com.mv.backend.enums.TipoAtendimento;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@ActiveProfiles("test")
class AgendamentoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<AgendamentoRequestDTO> agendamentoRequestJson;

    @Test
    @DisplayName("Deveria devolver codigo HTTP 400 quando informacoes estao invalidas")
    void cadastrar_cenario1() throws Exception {
        var response = mvc.perform(post("/agendamentos")).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo HTTP 400 quando a data for no passado")
    void cadastrar_cenario2() throws Exception {

        // LocalDateTime.now().minusDays(1) para gerar dinamicamente uma data no passado
        var dtoInvalido = new AgendamentoRequestDTO(
                1L,
                1L,
                LocalDateTime.now().minusDays(1),
                TipoAtendimento.EXAME
        );

        var response = mvc.perform(
                post("/agendamentos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(agendamentoRequestJson.write(dtoInvalido).getJson())
        ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}

