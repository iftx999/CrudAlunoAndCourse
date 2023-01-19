import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlunoComponent } from './components/aluno/aluno.component';
import { AlunoFormComponent } from './containers/aluno-form/aluno-form.component';
import { AlunoResolver } from './guards/aluno.resolver';
const routes: Routes = [
  { path: '', component: AlunoComponent },
  { path: 'new', component: AlunoFormComponent, resolve: { aluno: AlunoResolver } },
  { path: 'edit/:id', component: AlunoFormComponent, resolve: { aluno:   { path: 'new', component: AlunoFormComponent, resolve: { aluno: AlunoResolver } },
} }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlunoRoutingModule { }
