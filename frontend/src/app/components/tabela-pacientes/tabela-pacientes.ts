import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { RouterModule } from '@angular/router';
import { DadosPaciente, PacienteService } from '../../services/paciente';

@Component({
  selector: 'app-tabela-pacientes',
  standalone: true,
  imports: [CommonModule, MatTableModule, MatButtonModule, MatIconModule, MatCardModule, RouterModule],
  templateUrl: './tabela-pacientes.html',
  styleUrl: './tabela-pacientes.scss',
})

export class TabelaPacientes implements OnInit {
  colunasExibidas: string[] = ['nome', 'email'];
  pacientes: DadosPaciente[] = [];

  constructor(
    private pacienteService: PacienteService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit() {
    this.pacienteService.listar().subscribe({
      next: (dados) => {
        this.pacientes = dados;
        this.cdr.detectChanges();
      },
      error: (erro) => console.error('Erro ao buscar pacientes:', erro)
    });
  }
}