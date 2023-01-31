import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LocationsService } from './../../Services/locations.service';

@Component({
  selector: 'app-locations',
  templateUrl: './locations.component.html',
  styleUrls: ['./locations.component.css']
})
export class LocationsComponent {

  allLocations: any;
  constructor(private locationsService: LocationsService) {}

  ngOnInit(){
    this.locationsService.getLocationsByConcessionnaire().subscribe({
      next: (response) => {
        this.allLocations = response
        console.log(this.allLocations);
        
      }
    });
  }

  showDetailLocation(){
  }
}
