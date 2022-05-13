import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BlogComponent } from './blog/blog.component';
import { AboutComponent } from './about/about.component';
import { BlogDetailComponent } from './blog/blog-detail/blog-detail.component';


import { FullComponent } from './layout/full/full.component';
import { RateComponent } from '../rate/rate.component';
import { UpdateRateComponent } from '../update-rate/update-rate.component';
import { AddRateComponent } from '../add-rate/add-rate.component';
import { RateOthersComponent } from '../rate-others/rate-others.component';
import { TropheeComponent } from '../trophee/trophee.component';
import { AddTropheeComponent } from '../add-trophee/add-trophee.component';
import { UpdateTropheeComponent } from '../update-trophee/update-trophee.component';
import { ListTropheeComponent } from '../list-trophee/list-trophee.component';
import { QuizComponent } from '../quiz/quiz.component';
import { AddQuizComponent } from '../add-quiz/add-quiz.component';
import { UpdateQuizComponent } from '../update-quiz/update-quiz.component';
import { TraiterQuizComponent } from '../traiter-quiz/traiter-quiz.component';
import { AddQuizQuestionComponent } from '../add-quiz-question/add-quiz-question.component';
import { UpdateQuizQuestionComponent } from '../update-quiz-question/update-quiz-question.component';
import { ListQuizComponent } from '../list-quiz/list-quiz.component';
import { PasserQuizComponent } from '../passer-quiz/passer-quiz.component';
import { VerifierNoteQuizComponent } from '../verifier-note-quiz/verifier-note-quiz.component';
import { ResultatQuizComponent } from '../resultat-quiz/resultat-quiz.component';


const routes: Routes = [
  {
    path: '',
    component: FullComponent,
    children: [
      { path: '', component: BlogComponent },
      { path: 'blogDetail/:id', component: BlogDetailComponent },
      { path: 'about', component: AboutComponent },
      {path: 'rate', component: RateComponent},
      {path: 'update-rate/:id', component: UpdateRateComponent},
      {path: 'add-rate', component: AddRateComponent},
      {path: 'other-profile/:idUser/:idOther' , component: RateOthersComponent},
      {path: 'trophee' , component: TropheeComponent},
      {path: 'add-trophee' , component: AddTropheeComponent},
      {path: 'update-trophee/:id', component: UpdateTropheeComponent},
      {path: 'list-trophee/:idUser' , component: ListTropheeComponent},
      {path: 'quiz' , component: QuizComponent},
      {path: 'add-quiz' , component: AddQuizComponent},
      {path: 'update-quiz/:id', component: UpdateQuizComponent},
      {path: 'traiter-quiz/:id', component: TraiterQuizComponent},
      {path: 'add-quizQuestion/:id' , component: AddQuizQuestionComponent},
      {path: 'update-quizQuestion/:idQuiz/:idQuestion' , component: UpdateQuizQuestionComponent},
      {path: 'list-quiz/:idUser' , component: ListQuizComponent},
      {path: 'passer-quiz/:idUser/:idQuiz' , component: PasserQuizComponent},
      {path: 'verifier-note-quiz/:idUser/:idQuiz' , component: VerifierNoteQuizComponent},
      {path: 'resultat-quiz/:idUser/:idQuiz' , component: ResultatQuizComponent},
    
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppsRoutingModule { }
