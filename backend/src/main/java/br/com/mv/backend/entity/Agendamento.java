package br.com.mv.backend.entity;

import br.com.mv.backend.dto.AgendamentoRequestDTO;
import br.com.mv.backend.dto.CancelamentoRequestDTO;
import br.com.mv.backend.enums.StatusAgendamento;
import br.com.mv.backend.enums.TipoAtendimento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Table(name = "agendamentos")
@Entity(name = "Agendamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agendamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Profissional profissional;

    @ManyToOne
    private Paciente paciente;

    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private TipoAtendimento tipoAtendimento;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;

    private String motivoCancelamento;

    public Agendamento(Profissional profissional, Paciente paciente, LocalDateTime dataHora, TipoAtendimento tipoAtendimento){
        this.profissional = profissional;
        this.paciente = paciente;
        this.dataHora = dataHora;
        this.tipoAtendimento = tipoAtendimento;
        this.status = StatusAgendamento.AGENDADO;
    }

    public void cancelar(CancelamentoRequestDTO dadosCancelamento){
        this.status = StatusAgendamento.CANCELADO;
        this.motivoCancelamento = dadosCancelamento.motivo();
    }

}
