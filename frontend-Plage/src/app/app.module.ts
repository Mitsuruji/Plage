import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PLAGE_ROUTING } from './app.routing';
import { HomeComponent } from './home/home.component';
import { tokenInterceptorProvider } from './Interceptor/access-token.interceptor';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RegisterComponent } from './register/register.component';
import { ReservationsComponent } from './client/reservations/reservations.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    NavbarComponent,
    RegisterComponent,
    ReservationsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    PLAGE_ROUTING,
    HttpClientModule
  ],
  providers: [tokenInterceptorProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
