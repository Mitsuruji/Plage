import { RouterModule, Routes } from '@angular/router';
import { LogoutGuard } from './Guards/logout.guard';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LocationsComponent } from './concessionnaire/locations/locations.component';
import { ConcessionnaireGuard } from './Guards/concessionnaire.guard';
import { LocationDetailComponent } from './concessionnaire/location-detail/location-detail.component';

const myRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent, canActivate: [LogoutGuard] },
  { path: 'concessionnaire', 
  children: [
    { path: 'locations', component: LocationsComponent, canActivate: [ConcessionnaireGuard] },
    { path: 'location-details', component: LocationDetailComponent, canActivate: [ConcessionnaireGuard] }
  ]},
  { path: 'client/register', component: RegisterComponent },
  { path: '**', redirectTo: '' }
];

export const PLAGE_ROUTING = RouterModule.forRoot(myRoutes);
