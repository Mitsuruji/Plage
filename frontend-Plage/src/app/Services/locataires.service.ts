import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable, Subject } from 'rxjs';
import { Locataire } from '../models/locataire.model';

@Injectable({
  providedIn: 'root',
})
export class LocatairesService {
  private locataires = new Subject<Locataire[]>();
  private linkLocataire = 'http://localhost:8080/api/file';

  constructor(private http: HttpClient) {}

  files$ = this.locataires.asObservable();

  getAllFiles(): Observable<Locataire[]> {
    return this.http.get<Locataire[]>(this.linkLocataire).pipe(
      map((locataire: Locataire[]) => {
        this.locataires.next(locataire);
        return locataire;
      })
    );
  }
}
