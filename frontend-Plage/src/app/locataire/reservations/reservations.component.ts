import { Component } from '@angular/core';
import { LocationsService } from 'src/app/services/locations.service';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css'],
})
export class ReservationsComponent {
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
