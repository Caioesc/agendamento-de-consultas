import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TabelaAgendamentos } from './tabela-agendamentos';

describe('TabelaAgendamentos', () => {
  let component: TabelaAgendamentos;
  let fixture: ComponentFixture<TabelaAgendamentos>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TabelaAgendamentos],
    }).compileComponents();

    fixture = TestBed.createComponent(TabelaAgendamentos);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
