import { Component } from '@angular/core';
import { Pays } from '../models/pays.model';
import { PaysService } from '../services/pays.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  showError = false;
  listPays = ['France', 'Allemagne', 'Espagne', 'Italie', 'Suisse'];

  constructor(private paysService: PaysService) {}

  ngOnInit(): void {}

  onSubmit() {}
}
