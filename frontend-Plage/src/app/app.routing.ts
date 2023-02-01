import { AddReservationComponent } from './locataire/add-reservation/add-reservation.component';
import { ReservationsComponent } from './locataire/reservations/reservations.component';
import { RouterModule, Routes } from '@angular/router';
import { LogoutGuard } from './guards/logout.guard';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LocationsComponent } from './concessionnaire/locations/locations.component';
import { ConcessionnaireGuard } from './guards/concessionnaire.guard';
import { LocationDetailComponent } from './concessionnaire/location-detail/location-detail.component';

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
    ],
  },
  {
    path: 'client',
    children: [
      { path: 'register', component: RegisterComponent },
      { path: 'reservation', component: ReservationsComponent },
      { path: 'reservation/add', component: AddReservationComponent },
    ],
  },
  { path: '**', redirectTo: '' },
];

export const PLAGE_ROUTING = RouterModule.forRoot(myRoutes);
