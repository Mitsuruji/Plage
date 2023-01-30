import { Component } from '@angular/core';
import { LocationService } from 'src/app/Services/location.service';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css'],
})
export class ReservationsComponent {
  locations!: Location[];

  constructor(private locationService: LocationService) {}

  // ngOnInit() {
  //   this.locationService.getLocationsByLocataire().subscribe((locations) => {
  //     this.locations = locations.filter(
  //       (location) =>
  //         location.statut === 'VALIDE' || location.statut === 'ACCEPTE'
  //     );
  //   });
  // }
}
