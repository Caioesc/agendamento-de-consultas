import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { Agendamento, AgendamentoService } from '../../services/agendamento';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { PacienteService } from '../../services/paciente';


@Component({
  selector: 'app-tabela-agendamentos',
  imports: [MatTableModule, CommonModule, MatCardModule, MatButtonModule, MatIconModule, RouterModule, FormsModule, MatFormFieldModule, MatSelectModule, MatInputModule],
  templateUrl: './tabela-agendamentos.html',
  styleUrl: './tabela-agendamentos.scss',
})
export class TabelaAgendamentos implements OnInit {

  pacientes: any[] = [];
  profissionaisMock = [
    { id: 1, nome: 'Dr. João Silva', especialidade: 'CARDIOLOGIA' },
    { id: 2, nome: 'Dra. Ana Costa', especialidade: 'DERMATOLOGIA' },
    { id: 3, nome: 'Dra. Juliana Alves', especialidade: 'GINECOLOGIA' },
    { id: 4, nome: 'Dr. Carlos Neto', especialidade: 'ORTOPEDIA' }
  ];

  filtroStatus: string = '';
  filtroPacienteId: string = '';
  filtroProfissionalId: string = '';

  carregarPacientes() {
    this.pacienteService.listar().subscribe(dados => this.pacientes = dados);
  }


  cancelarConsulta(id: number) {
    const motivoCancelamento = window.prompt('Por favor, informe o motivo do cancelamento:');

    if (motivoCancelamento?.trim() === '' || motivoCancelamento === null) {
      alert('O motivo do cancelamento é obrigatório para cancelar a consulta!');
      return;
    }

    const payload = {
      motivo: motivoCancelamento
    };

    this.agendamentoService.cancelar(id, payload).subscribe({
      next: () => {
        alert('Consulta cancelada com sucesso!');
        this.ngOnInit();
      },
      error: (erro) => {
        console.error('Erro ao cancelar:', erro);
        alert('Erro ao cancelar a consulta.');
      }
    });
  }

  colunasExibidas: string[] = ['paciente', 'profissional', 'dataHora', 'tipoAtendimento', 'status', 'motivoCancelamento', 'acoes'];

  constructor(private agendamentoService: AgendamentoService, private pacienteService: PacienteService, private cdr: ChangeDetectorRef) { }

  agendamentos: Agendamento[] = [];

  listar() {
    const filtros: any = {};
    if (this.filtroStatus) filtros.status = this.filtroStatus;
    if (this.filtroPacienteId) filtros.pacienteId = this.filtroPacienteId;
    if (this.filtroProfissionalId) filtros.profissionalId = this.filtroProfissionalId;

    this.agendamentoService.listar(filtros).subscribe(dados => {
      this.agendamentos = dados;
      this.cdr.detectChanges();
    });
  }

  limparFiltros() {
    this.filtroStatus = '';
    this.filtroPacienteId = '';
    this.filtroProfissionalId = '';
    this.listar();
  }

  ngOnInit(): void {
    this.carregarPacientes();
    this.listar()
  }

}
