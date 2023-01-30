import { Component } from '@angular/core';
import { Pays } from '../model/pays.model';
import { PaysService } from '../Services/pays.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  listPays = ['France', 'Allemagne', 'Espagne', 'Italie', 'Suisse'];

  constructor(private paysService: PaysService) {}

  ngOnInit(): void {}

  onSubmit() {}
}
