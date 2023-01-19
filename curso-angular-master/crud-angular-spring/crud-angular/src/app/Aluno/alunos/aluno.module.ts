import { AlunoRoutingModule } from './aluno-routing.module';
import { AlunoFormComponent } from './containers/aluno-form/aluno-form.component';
import { AlunoComponent } from './components/aluno/aluno.component';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { AppMaterialModule } from 'src/app/shared/app-material/app-material.module';
import { SharedModule } from 'src/app/shared/shared.module';
@NgModule({
  declarations: [
    AlunoComponent,
    AlunoFormComponent,
    AlunoComponent,
  ],
  imports: [
    CommonModule,
    AlunoRoutingModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule
  ]
})
export class AlunoModule { }
