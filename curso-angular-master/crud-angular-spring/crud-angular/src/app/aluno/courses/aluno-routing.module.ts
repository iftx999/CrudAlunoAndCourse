import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CoursesResolver } from './guards/aluno.resolver';
import { CoursesComponent } from './containers/aluno/courses.component';
import { CourseFormComponent } from './containers/aluno-form/aluno-form.component';
const routes: Routes = [
  { path: '', component: CoursesComponent },
  { path: 'new', component: CourseFormComponent, resolve: { course: CoursesResolver } },
  { path: 'edit/:id', component: CourseFormComponent, resolve: { course: CoursesResolver } }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CoursesRoutingModule { }
