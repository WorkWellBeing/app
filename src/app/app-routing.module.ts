import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddQuizQuestionComponent } from './add-quiz-question/add-quiz-question.component';
import { AddQuizComponent } from './add-quiz/add-quiz.component';
import { AddRateComponent } from './add-rate/add-rate.component';
import { AddTropheeComponent } from './add-trophee/add-trophee.component';
import { ListQuizComponent } from './list-quiz/list-quiz.component';
import { ListTropheeComponent } from './list-trophee/list-trophee.component';
import { PasserQuizComponent } from './passer-quiz/passer-quiz.component';
import { QuizComponent } from './quiz/quiz.component';
import { RateOthersComponent } from './rate-others/rate-others.component';
import { RateComponent } from './rate/rate.component';
import { ResultatQuizComponent } from './resultat-quiz/resultat-quiz.component';
import { TraiterQuizComponent } from './traiter-quiz/traiter-quiz.component';
import { TropheeComponent } from './trophee/trophee.component';
import { UpdateQuizQuestionComponent } from './update-quiz-question/update-quiz-question.component';
import { UpdateQuizComponent } from './update-quiz/update-quiz.component';
import { UpdateRateComponent } from './update-rate/update-rate.component';
import { UpdateTropheeComponent } from './update-trophee/update-trophee.component';
import { VerifierNoteQuizComponent } from './verifier-note-quiz/verifier-note-quiz.component';



const routes: Routes = [
  {
    path: '',
    children: [
      // { path: '', redirectTo: '/apps', pathMatch: 'full' },
      { path: '', loadChildren: () => import('./apps/apps.module').then(m => m.AppsModule) }
    ]
  },
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
