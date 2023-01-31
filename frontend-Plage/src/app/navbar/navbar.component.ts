import { Component } from '@angular/core';
import { AuthentificationService } from '../Services/authentification.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent {
  constructor(public authSer: AuthentificationService) {}
}
