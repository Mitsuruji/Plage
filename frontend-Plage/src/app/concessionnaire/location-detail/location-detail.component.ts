import { Component } from '@angular/core';
import { LocationsService } from 'src/app/services/locations.service';

@Component({
  selector: 'app-location-detail',
  templateUrl: './location-detail.component.html',
  styleUrls: ['./location-detail.component.css'],
})
export class LocationDetailComponent {
  locationDetails: any;

  constructor(private locationsService: LocationsService) {}

  ngOnInit(){
    this.locationDetails = this.locationsService.getSelectedLocation();
    console.log(this.locationDetails)
    
  }
}
