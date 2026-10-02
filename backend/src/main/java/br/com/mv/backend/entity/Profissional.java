package br.com.mv.backend.entity;

import br.com.mv.backend.enums.Especialidade;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "profissionais")
@Entity(name = "Profissional")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Profissional {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
}
