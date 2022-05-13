import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerifierNoteQuizComponent } from './verifier-note-quiz.component';

describe('VerifierNoteQuizComponent', () => {
  let component: VerifierNoteQuizComponent;
  let fixture: ComponentFixture<VerifierNoteQuizComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VerifierNoteQuizComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VerifierNoteQuizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
