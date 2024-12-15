import { TestBed } from '@angular/core/testing';

import { TrainerFormService } from './trainer-form-service.service';

describe('TrainerFormServiceService', () => {
  let service: TrainerFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TrainerFormService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
