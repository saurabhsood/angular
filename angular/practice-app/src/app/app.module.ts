import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';

import { HomeComponent } from './home/home.component';
import { DropdownDirective } from './shared/dropdown.directive';
import { CreateClientComponent } from './client/add/create-client/create-client.component';
import { InquireClientComponent } from './client/inquire/inquire-client/inquire-client.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpInterceptorService } from './shared/http/http-interceptor.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    DropdownDirective,
    CreateClientComponent,
    InquireClientComponent,
 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS,
    useClass: HttpInterceptorService,
    multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
