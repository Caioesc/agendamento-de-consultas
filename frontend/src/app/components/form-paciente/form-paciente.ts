import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { RouterModule, Router } from '@angular/router';
import { PacienteService } from '../../services/paciente';
import { NgxMaskDirective } from 'ngx-mask';

@Component({
  selector: 'app-form-paciente',
  imports: [CommonModule, ReactiveFormsModule, MatFormFieldModule, MatInputModule, MatButtonModule, MatCardModule, RouterModule, NgxMaskDirective],
  templateUrl: './form-paciente.html',
  styleUrl: './form-paciente.scss',
})


export class FormPaciente {
  formulario: FormGroup;

  constructor(private formBuilder: FormBuilder, private pacienteService: PacienteService, private router: Router) {

    this.formulario = this.formBuilder.group({
      nome: ['', Validators.required],
      cpf: ['', Validators.required],
      telefone: ['', Validators.required],
      email: ['', Validators.required]
    })
  }

  salvar() {
    if (this.formulario.valid) {
      const dadosFormulario = this.formulario.value;

      this.pacienteService.cadastrar(dadosFormulario).subscribe({
        next: () => {
          alert('Paciente cadastrado com sucesso!');
          this.router.navigate(['/pacientes']);
        },
        error: (response) => {
          let mensagemErro: string = "Atenção: \n"

          console.error('Erro na requisição:', response);

          if (response.error.length > 0) {
            for (let i = 0; i < response.error.length; i++) {
              mensagemErro = mensagemErro + `${i+1} - ` + response.error[i].mensagem + "\n"
            }
            alert(mensagemErro)
          } else {
            alert("Erro inesperado ao cadastrar um novo paciente")
          }
        }
      });
    }
  }
}
