import { ChangeDetectorRef, Component , OnInit} from '@angular/core';
import {MatTableModule} from '@angular/material/table';
import { Agendamento, AgendamentoService } from '../../services/agendamento';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { RouterModule } from '@angular/router';


@Component({
  selector: 'app-tabela-agendamentos',
  imports: [MatTableModule, CommonModule, MatCardModule, MatButtonModule, MatIconModule, RouterModule],
  templateUrl: './tabela-agendamentos.html',
  styleUrl: './tabela-agendamentos.scss',
})
export class TabelaAgendamentos implements OnInit{
  colunasExibidas: string[] = ['paciente', 'profissional', 'dataHora', 'tipoAtendimento', 'status', 'motivoCancelamento', 'acoes'];

  constructor(private agendamentoService: AgendamentoService, private cdr: ChangeDetectorRef) {}

  agendamentos: Agendamento[] = [];

  ngOnInit(): void {
    this.agendamentoService.listar().subscribe(dados => {this.agendamentos = dados; 
      this.cdr.detectChanges();
    });
  }

}
