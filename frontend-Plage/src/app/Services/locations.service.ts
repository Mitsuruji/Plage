import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LocationsService {
  constructor(private http: HttpClient) {}

  linkConcessionnaire = 'http://localhost:8080/api/concessionnaire/locations';

  linkClient = 'http://localhost:8080/api/locataire/locations';

  notify = new BehaviorSubject<any>('');

  notifyObservable$ = this.notify.asObservable();

  notifyOther(data: any) {
    if (data) {
      this.notify.next(data);
    }
  }

  // getLocationById(id: number) {
  //   return this.http.get(this.linkConcessionnaire);
  // }

  getLocationsByConcessionnaire() {
    return this.http.get(this.linkConcessionnaire);
  }

  getLocationsByLocataire() {
    return this.http.get(this.linkClient);
  }
}
