import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Agendamento{
  id: number
  nomePaciente: string,
  nomeProfissional: string,
  dataHora: string,
  statusAgendamento: string
}


@Injectable({
  providedIn: 'root',
})

export class AgendamentoService {
  private apiUrl = 'http://localhost:8080/agendamentos';

  constructor(private http: HttpClient) { }

  listar(): Observable<Agendamento[]> {
    return this.http.get<Agendamento[]>(this.apiUrl);
  }
}
