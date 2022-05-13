import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTropheeComponent } from './add-trophee.component';

describe('AddTropheeComponent', () => {
  let component: AddTropheeComponent;
  let fixture: ComponentFixture<AddTropheeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddTropheeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddTropheeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
