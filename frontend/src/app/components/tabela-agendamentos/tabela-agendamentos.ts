import { Component , OnInit} from '@angular/core';
import {MatTableModule} from '@angular/material/table';
import { Agendamento, AgendamentoService } from '../../services/agendamento';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';


@Component({
  selector: 'app-tabela-agendamentos',
  imports: [MatTableModule, CommonModule, MatCardModule, MatButtonModule, MatIconModule],
  templateUrl: './tabela-agendamentos.html',
  styleUrl: './tabela-agendamentos.scss',
})
export class TabelaAgendamentos {
  colunasExibidas: string[] = ['paciente', 'profissional', 'dataHora', 'tipoAtendimento', 'status', 'motivoCancelamento', 'acoes'];

  constructor(private agendamentoService: AgendamentoService) {}

  agendamentos: Agendamento[] = [];

  ngOnInit(): void {
    this.agendamentoService.listar().subscribe(dados => {this.agendamentos = dados;});
  }

}
