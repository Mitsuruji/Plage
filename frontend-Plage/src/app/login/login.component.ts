import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthentificationService } from '../services/authentification.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  showError = false;

  constructor(
    private authService: AuthentificationService,
    private router: Router
  ) {}

  submitHandler(f: any) {
    this.authService.connect(f.value).subscribe({
      next: (response: any) => {
        localStorage.setItem('myToken', response['token']);
        this.router.navigateByUrl('');
      },
      error: (err) => {
        this.showError = true;
        f.reset();
      },
    });
  }
}
