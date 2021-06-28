import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateClientComponent } from './client/add/create-client/create-client.component';
import { InquireClientComponent } from './client/inquire/inquire-client/inquire-client.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [{path:'', redirectTo:'home',pathMatch:'full'},{path:'home', component:HomeComponent},
{path:"createClient", component: CreateClientComponent}, {path:"inquireClient",component:InquireClientComponent}];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
