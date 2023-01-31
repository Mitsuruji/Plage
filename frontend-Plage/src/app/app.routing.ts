import { ReservationComponent } from './client/reservation/reservation.component';
import { RouterModule, Routes } from '@angular/router';
import { LogoutGuard } from './Guards/logout.guard';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LocationsComponent } from './concessionnaire/locations/locations.component';
import { ConcessionnaireGuard } from './Guards/concessionnaire.guard';
import { AddReservationComponent } from './client/add-reservation/add-reservation.component';

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
    ],
  },
  {
    path: 'client',
    children: [
      { path: 'register', component: RegisterComponent },
      { path: 'reservation', component: ReservationComponent },
      { path: 'reservation/add', component: AddReservationComponent },
    ],
  },
];

export const PLAGE_ROUTING = RouterModule.forRoot(myRoutes);
