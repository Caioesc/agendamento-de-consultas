import { Component , OnInit} from '@angular/core';
import {MatTableModule} from '@angular/material/table';
import { Agendamento, AgendamentoService } from '../../services/agendamento';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-tabela-agendamentos',
  imports: [MatTableModule, CommonModule],
  templateUrl: './tabela-agendamentos.html',
  styleUrl: './tabela-agendamentos.scss',
})
export class TabelaAgendamentos {
  colunasExibidas: string[] = ['paciente', 'profissional', 'dataHora', 'tipoAtendimento', 'status', 'motivoCancelamento'];

  constructor(private agendamentoService: AgendamentoService) {}

  agendamentos: Agendamento[] = [];

  ngOnInit(): void {
    this.agendamentoService.listar().subscribe(dados => {this.agendamentos = dados;});
  }

}
