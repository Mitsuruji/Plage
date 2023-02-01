import { Component } from '@angular/core';
import { LocationsService } from 'src/app/services/locations.service';
import { Location } from '../../models/location.model';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css'],
})
export class ReservationsComponent {
  firstLocation!: Location;
  allLocations!: Location[];
  router: any;

  constructor(private locationsService: LocationsService) {}

  ngOnInit() {
    this.locationsService.getLocationsByLocataire().subscribe({
      next: (response) => {
        this.allLocations = response as Location[];
        this.firstLocation = this.allLocations[0];
      },
    });
  }
}
