import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TraiterQuizComponent } from './traiter-quiz.component';

describe('TraiterQuizComponent', () => {
  let component: TraiterQuizComponent;
  let fixture: ComponentFixture<TraiterQuizComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TraiterQuizComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TraiterQuizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
