import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LocationsService {
  constructor(private http: HttpClient) {}

  linkConcessionnaire = 'http://localhost:8080/api/concessionnaire/locations';

  linkClient = 'http://localhost:8080/api/locataire/location';

  notify = new BehaviorSubject<any>('');

  notifyObservable$ = this.notify.asObservable();

  selectedLocation: any;

  notifyOther(data: any) {
    if (data) {
      this.notify.next(data);
    }
  }

  getSelectedLocation(){
    return this.selectedLocation;
  }

  setSelectedLocation(location : any) {
    this.selectedLocation = location;
  }

  getLocationsByConcessionnaire() {
    return this.http.get(this.linkConcessionnaire);
  }

  getLocationsByLocataire() {
    return this.http.get(this.linkClient);
  }
}
