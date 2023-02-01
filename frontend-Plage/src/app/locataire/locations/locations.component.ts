import { Component } from '@angular/core';
import { LocationsService } from 'src/app/services/locations.service';

@Component({
  selector: 'app-locations',
  templateUrl: './locations.component.html',
  styleUrls: ['./locations.component.css'],
})
export class LocationsComponent {
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
