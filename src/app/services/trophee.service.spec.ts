import { TestBed } from '@angular/core/testing';

import { TropheeService } from './trophee.service';

describe('TropheeService', () => {
  let service: TropheeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TropheeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
