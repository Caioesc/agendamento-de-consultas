import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAgendamento } from './form-agendamento';

describe('FormAgendamento', () => {
  let component: FormAgendamento;
  let fixture: ComponentFixture<FormAgendamento>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormAgendamento],
    }).compileComponents();

    fixture = TestBed.createComponent(FormAgendamento);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
