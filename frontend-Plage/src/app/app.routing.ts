import { RouterModule, Routes } from "@angular/router";
import { HomeComponent } from "./home/home.component";
import { LoginComponent } from "./login/login.component";


const myRoutes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'login', component: LoginComponent }
]

export const PLAGE_ROUTING = RouterModule.forRoot(myRoutes);