import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TabelaPacientes } from './tabela-pacientes';

describe('TabelaPacientes', () => {
  let component: TabelaPacientes;
  let fixture: ComponentFixture<TabelaPacientes>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TabelaPacientes],
    }).compileComponents();

    fixture = TestBed.createComponent(TabelaPacientes);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
