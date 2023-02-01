import { ClientsComponent } from './concessionnaire/clients/clients.component';
import { AddReservationComponent } from './locataire/add-reservation/add-reservation.component';
import { ReservationsComponent } from './locataire/reservations/reservations.component';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LocationsComponent } from './concessionnaire/locations/locations.component';
import { LocationDetailComponent } from './concessionnaire/location-detail/location-detail.component';
import { LocataireGuard } from './Guards/locataire.guard';
import { LogoutGuard } from './guards/logout.guard';
import { ConcessionnaireGuard } from './guards/concessionnaire.guard';

const myRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent, canActivate: [LogoutGuard] },
  {
    path: 'concessionnaire',
    children: [
      {
        path: 'locations',
        component: LocationsComponent,
        canActivate: [ConcessionnaireGuard],
      },
      {
        path: 'location-details',
        component: LocationDetailComponent,
        canActivate: [ConcessionnaireGuard],
      },
      {
        path: 'clients',
        component: ClientsComponent,
        canActivate: [ConcessionnaireGuard],
      },
    ],
  },
  {
    path: 'client',
    children: [
      { path: 'register', component: RegisterComponent },
      {
        path: 'reservation',
        component: ReservationsComponent,
        canActivate: [LocataireGuard],
      },
      {
        path: 'reservation/add',
        component: AddReservationComponent,
        canActivate: [LocataireGuard],
      },
    ],
  },
  { path: '**', redirectTo: '' },
];

export const PLAGE_ROUTING = RouterModule.forRoot(myRoutes);
