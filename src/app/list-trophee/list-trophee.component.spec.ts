import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListTropheeComponent } from './list-trophee.component';

describe('ListTropheeComponent', () => {
  let component: ListTropheeComponent;
  let fixture: ComponentFixture<ListTropheeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListTropheeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListTropheeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
