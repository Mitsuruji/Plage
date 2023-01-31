import { Component } from '@angular/core';
import { LocationsService } from 'src/app/Services/locations.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css'],
})
export class ReservationComponent {
  allLocations: any;
  constructor(private locationsService: LocationsService) {}

  ngOnInit() {
    this.locationsService.getLocationsByLocataire().subscribe({
      next: (response) => {
        this.allLocations = response;
        console.log(this.allLocations);
      },
    });
  }

  showDetailLocation() {}
}
