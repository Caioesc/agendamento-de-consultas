import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Cabecalho } from './components/cabecalho/cabecalho';
import { TabelaAgendamentos } from './components/tabela-agendamentos/tabela-agendamentos';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Cabecalho, TabelaAgendamentos],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('frontend');
}
