import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormPaciente } from './form-paciente';

describe('FormPaciente', () => {
  let component: FormPaciente;
  let fixture: ComponentFixture<FormPaciente>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormPaciente],
    }).compileComponents();

    fixture = TestBed.createComponent(FormPaciente);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
