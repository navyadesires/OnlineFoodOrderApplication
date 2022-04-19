import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeadingnameComponent } from './headingname.component';

describe('HeadingnameComponent', () => {
  let component: HeadingnameComponent;
  let fixture: ComponentFixture<HeadingnameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeadingnameComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HeadingnameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
