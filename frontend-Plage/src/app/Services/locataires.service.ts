import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LocatairesService {
  constructor(private http: HttpClient) {}

  // linkClient = 'http://localhost:8080/api/locataire/locations';

  // notify = new BehaviorSubject<any>('');

  // notifyObservable$ = this.notify.asObservable();

  // notifyOther(data: any) {
  //   if (data) {
  //     this.notify.next(data);
  //   }
  // }

  // // getLocationById(id: number) {
  // //   return this.http.get(this.linkConcessionnaire);
  // // }

  // getLocationsByConcessionnaire() {
  //   return this.http.get(this.linkConcessionnaire);
  // }

  // getLocationsByLocataire() {
  //   return this.http.get(this.linkClient);
  // }
}
