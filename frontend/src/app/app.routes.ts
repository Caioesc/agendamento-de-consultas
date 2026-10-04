import { Routes } from '@angular/router';
import { TabelaAgendamentos } from './components/tabela-agendamentos/tabela-agendamentos';
import { FormAgendamento } from './components/form-agendamento/form-agendamento';
import { TabelaPacientes} from './components/tabela-pacientes/tabela-pacientes';
import { FormPaciente } from './components/form-paciente/form-paciente';

export const routes: Routes = [
    {
        path: '', component: TabelaAgendamentos
    },
    {
        path: 'novoagendamento', component: FormAgendamento
    },
    {
        path: 'pacientes', component: TabelaPacientes
    },
    {
        path: 'cadastrarpaciente', component: FormPaciente
    }
];
