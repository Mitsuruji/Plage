import { Component } from '@angular/core';
import { Locataire } from 'src/app/models/locataire.model';
import { LocatairesService } from 'src/app/services/locataires.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css'],
})
export class ClientsComponent {
  firstLocataire!: Locataire;
  locataires!: Locataire[];
  router: any;

  constructor(private locatairesService: LocatairesService) {}

  ngOnInit() {
    this.locatairesService.getAllLocataires().subscribe({
      next: (response) => {
        this.locataires = response as Locataire[];
        this.firstLocataire = this.locataires[0];
      },
    });
  }
  removeLocataire(index: number) {
    this.locatairesService.getAllLocataires().subscribe({
      next: (response) => {
        this.locataires = response as Locataire[];
        this.firstLocataire = this.locataires[0];
      },
    });
  }
}
