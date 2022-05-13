import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateTropheeComponent } from './update-trophee.component';

describe('UpdateTropheeComponent', () => {
  let component: UpdateTropheeComponent;
  let fixture: ComponentFixture<UpdateTropheeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateTropheeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateTropheeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
