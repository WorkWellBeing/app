import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RateOthersComponent } from './rate-others.component';

describe('RateOthersComponent', () => {
  let component: RateOthersComponent;
  let fixture: ComponentFixture<RateOthersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RateOthersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RateOthersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
