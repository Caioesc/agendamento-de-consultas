import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface DadosPaciente {
  id: number;
  nome: string;
  email: string;
}

@Injectable({
  providedIn: 'root'
})
export class PacienteService {
  private apiUrl = 'http://localhost:8080/pacientes';

  constructor(private http: HttpClient) { }

  listar(): Observable<DadosPaciente[]> {
    return this.http.get<DadosPaciente[]>(this.apiUrl);
  }
}