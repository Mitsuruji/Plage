import { Component } from '@angular/core';
import { LocationsService } from 'src/app/Services/locations.service';

@Component({
  selector: 'app-location-detail',
  templateUrl: './location-detail.component.html',
  styleUrls: ['./location-detail.component.css']
})
export class LocationDetailComponent {

  locationDetails : any;

  constructor(private locationsService: LocationsService) {}

  // ngOnInit(){
  //   this.locationsService.notifyObservable$.subscribe(res => {
  //     if(res.refresh){
  //       this.locationDetails = this.locationsService.getLocationById(1);
  //     }
  //   })
  // }
}
