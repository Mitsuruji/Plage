import { Component } from '@angular/core';
import { LocationsService } from '../../services/locations.service';

@Component({
  selector: 'app-locations',
  templateUrl: './locations.component.html',
  styleUrls: ['./locations.component.css'],
})
export class LocationsComponent {
  allLocations: any;
  constructor(private locationsService: LocationsService) {}

  ngOnInit() {
    this.locationsService.getLocationsByConcessionnaire().subscribe({
      next: (response) => {
        this.allLocations = response;
        console.log(this.allLocations);
      },
    });
  }

  showDetailsLocation(location : any) {
    this.locationsService.setSelectedLocation(location);
  }
}
