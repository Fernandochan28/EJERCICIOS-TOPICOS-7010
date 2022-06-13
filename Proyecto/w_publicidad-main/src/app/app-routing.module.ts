import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {UbicacionComponent} from './ubicacion/ubicacion.component';
import {CardComponent} from './card/card.component'

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'ubicacion', component: UbicacionComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'productos', component: CardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
