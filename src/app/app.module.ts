import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RateComponent } from './rate/rate.component';
import { UpdateRateComponent } from './update-rate/update-rate.component';
import { RateOthersComponent } from './rate-others/rate-others.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
//import { MatIconModule } from '@angular/material/icon';
import { AddRateComponent } from './add-rate/add-rate.component';
import { TropheeComponent } from './trophee/trophee.component';
import { AddTropheeComponent } from './add-trophee/add-trophee.component';
import { UpdateTropheeComponent } from './update-trophee/update-trophee.component';
import { ListTropheeComponent } from './list-trophee/list-trophee.component';
import { QuizComponent } from './quiz/quiz.component';
import { AddQuizComponent } from './add-quiz/add-quiz.component';
import { UpdateQuizComponent } from './update-quiz/update-quiz.component';
import { TraiterQuizComponent } from './traiter-quiz/traiter-quiz.component';
import { AddQuizQuestionComponent } from './add-quiz-question/add-quiz-question.component';
import { UpdateQuizQuestionComponent } from './update-quiz-question/update-quiz-question.component';
import { ListQuizComponent } from './list-quiz/list-quiz.component';
import { PasserQuizComponent } from './passer-quiz/passer-quiz.component';
import { VerifierNoteQuizComponent } from './verifier-note-quiz/verifier-note-quiz.component';
import { ResultatQuizComponent } from './resultat-quiz/resultat-quiz.component';







@NgModule({
  declarations: [
    AppComponent,
    RateComponent,
    UpdateRateComponent,
    RateOthersComponent,
    AddRateComponent,
    TropheeComponent,
    AddTropheeComponent,
    UpdateTropheeComponent,
    ListTropheeComponent,
    QuizComponent,
    AddQuizComponent,
    UpdateQuizComponent,
    TraiterQuizComponent,
    AddQuizQuestionComponent,
    UpdateQuizQuestionComponent,
    ListQuizComponent,
    PasserQuizComponent,
    VerifierNoteQuizComponent,
    ResultatQuizComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
