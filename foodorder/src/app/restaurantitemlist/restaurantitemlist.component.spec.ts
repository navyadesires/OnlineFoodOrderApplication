import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantitemlistComponent } from './restaurantitemlist.component';

describe('RestaurantitemlistComponent', () => {
  let component: RestaurantitemlistComponent;
  let fixture: ComponentFixture<RestaurantitemlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestaurantitemlistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RestaurantitemlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
