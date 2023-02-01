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
import { LoginGuard } from './guards/login.guard';
import { LocationsComponent } from './concessionnaire/locations/locations.component';
import { LocationDetailComponent } from './concessionnaire/location-detail/location-detail.component';
import { ReservationsComponent } from './locataire/reservations/reservations.component';
import { AddReservationComponent } from './locataire/add-reservation/add-reservation.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ConcessionnaireGuard } from './guards/concessionnaire.guard';
import { LogoutGuard } from './guards/logout.guard';
import { ClientsComponent } from './concessionnaire/clients/clients.component';
import { FormatDatePipe } from './Pipes/format-date.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    NavbarComponent,
    RegisterComponent,
    LocationsComponent,
    LocationDetailComponent,
    LocationsComponent,
    ReservationsComponent,
    AddReservationComponent,
    FormatDatePipe,
    ClientsComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    PLAGE_ROUTING,
    HttpClientModule,
    ReactiveFormsModule,
    NgbModule,
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
