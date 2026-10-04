import { Routes } from '@angular/router';
import { TabelaAgendamentos } from './components/tabela-agendamentos/tabela-agendamentos';
import { FormAgendamento } from './components/form-agendamento/form-agendamento';
import { TabelaPacientes} from './components/tabela-pacientes/tabela-pacientes';

export const routes: Routes = [
    {
        path: '', component: TabelaAgendamentos
    },
    {
        path: 'novoagendamento', component: FormAgendamento
    },
    {
        path: 'pacientes', component: TabelaPacientes
    }
];
