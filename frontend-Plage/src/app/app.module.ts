import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PLAGE_ROUTING } from './app.routing';
import { HomeComponent } from './home/home.component';
import { tokenInterceptorProvider } from './Interceptor/access-token.interceptor';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RegisterComponent } from './register/register.component';
import { LoginGuard } from './Guards/login.guard';
import { LogoutGuard } from './Guards/logout.guard';
import { LocationsComponent } from './concessionnaire/locations/locations.component';
import { ConcessionnaireGuard } from './Guards/concessionnaire.guard';
import { LocationDetailComponent } from './concessionnaire/location-detail/location-detail.component';
import { ReservationComponent } from './client/reservation/reservation.component';
import { AddReservationComponent } from './client/add-reservation/add-reservation.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    NavbarComponent,
    RegisterComponent,
    LocationsComponent,
    LocationDetailComponent,
    ReservationComponent,
    AddReservationComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    PLAGE_ROUTING,
    HttpClientModule,
    ReactiveFormsModule,
    NgbModule
  ],
  providers: [
    tokenInterceptorProvider,
    LoginGuard,
    LogoutGuard,
    ConcessionnaireGuard,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
