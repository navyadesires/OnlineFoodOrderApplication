import { TestBed } from '@angular/core/testing';

import { RestaurantloginService } from './restaurantlogin.service';

describe('RestaurantloginService', () => {
  let service: RestaurantloginService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestaurantloginService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
