import { AlunoModule } from './Aluno/alunos/aluno.module';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'courses' },
  { path: '', pathMatch: 'full', redirectTo: 'aluno' },
  {
    path: 'courses',
    loadChildren: () => import('./courses/courses.module').then(m => m.CoursesModule),

  },
  {
    path: 'aluno',
    loadChildren: () => import('./Aluno/aluno.module').then(m => m.AlunoModule),
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
