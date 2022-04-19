import { TestBed } from '@angular/core/testing';

import { CustomerregisterService } from './customerregister.service';

describe('CustomerregisterService', () => {
  let service: CustomerregisterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomerregisterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
