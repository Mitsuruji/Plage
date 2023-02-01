import { Component } from '@angular/core';
import { LocationsService } from 'src/app/services/locations.service';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css'],
})
export class ReservationsComponent {
  allReservations: any;
  constructor(private locationsService: LocationsService) {}

  ngOnInit() {
    this.locationsService.getLocationsByLocataire().subscribe({
      next: (response) => {
        this.allReservations = response;
        console.log(this.allReservations);
      },
    });
  }

  showDetailLocation() {}
}
