import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-locations',
  templateUrl: './locations.component.html',
  styleUrls: ['./locations.component.css']
})
export class LocationsComponent {

  allLocations: any;
  constructor(private http: HttpClient) {}

  link = 'http://localhost:8080/api/concessionnaire/locations';

  getAllLocations(){
    console.log(this.http.get(this.link));
    
    return this.http.get(this.link);
  }

  ngOnInit(){
    this.getAllLocations().subscribe({
      next: (response) => {
        this.allLocations = response
      }
    });
  }

  showDetailLocation(){
  }
}
