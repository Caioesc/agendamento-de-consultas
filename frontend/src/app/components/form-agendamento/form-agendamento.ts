import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { Router, RouterModule } from '@angular/router';
import { DadosPaciente, PacienteService } from '../../services/paciente';
import { AgendamentoService } from '../../services/agendamento';

@Component({
  selector: 'app-form-agendamento',
  imports: [CommonModule, ReactiveFormsModule, MatFormFieldModule, MatInputModule, MatSelectModule, MatButtonModule, MatCardModule, RouterModule],
  templateUrl: './form-agendamento.html',
  styleUrl: './form-agendamento.scss',
})
export class FormAgendamento {

  pacientes: DadosPaciente[] = [];

  //Dados de profissionais estão sendo mockados iguais aos que são gerados no banco via seed no backend, pois na documentação do que deve ser desenvolvido, não há o método de listar profissionais.
  profissionaisMock = [
    { id: 1, nome: 'Dr. João Silva' , especialidade: 'CARDIOLOGIA'},
    { id: 2, nome: 'Dra. Ana Costa', especialidade: 'DERMATOLOGIA' },
    { id: 3, nome: 'Dra. Juliana Alves', especialidade: 'GINECOLOGIA' },
    { id: 4, nome: 'Dr. Carlos Neto', especialidade: 'ORTOPEDIA' }
  ];

  tiposDeAtendimento: string[] = ['CONSULTA', 'EXAME', 'RETORNO'];

  formulario: FormGroup;

  constructor(private formBuilder: FormBuilder, private pacienteService: PacienteService, private agendamentoService: AgendamentoService, private router: Router){
    this.formulario = this.formBuilder.group({
      pacienteId: ['', Validators.required],
      profissionalId: ['', Validators.required],
      dataHora: ['', Validators.required],
      tipoAtendimento: ['', Validators.required]
    })
  }

  salvar() {
    if (this.formulario.valid) {
      const dadosFormulario = this.formulario.value;

      this.agendamentoService.cadastrar(dadosFormulario).subscribe({
        next: () => {
          alert('Agendamento cadastrado com sucesso!');
          this.router.navigate(['/']);
        },
        error: (erro) => {
          console.error('Erro na requisição:', erro);
          alert('Erro ao cadastrar agendamento.');
        }
      });
    }
  }

  ngOnInit(): void {
    this.pacienteService.listar().subscribe(dados => {this.pacientes = dados;});
  }
}
