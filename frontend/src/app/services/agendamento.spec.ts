import { TestBed } from '@angular/core/testing';

import { Agendamento } from './agendamento';

describe('Agendamento', () => {
  let service: Agendamento;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Agendamento);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
