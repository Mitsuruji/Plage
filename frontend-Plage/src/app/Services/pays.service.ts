import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable, Subject } from 'rxjs';
import { Pays } from '../models/pays.model';

@Injectable({
  providedIn: 'root',
})
export class PaysService {
  private allPays = new Subject<Pays[]>();
  private linkAllPays =
    'https://restcountries.com/v2/all?fields=alpha2Code,name';

  constructor(private http: HttpClient) {}

  pays$ = this.allPays.asObservable();

  getAllPays(): Observable<Pays[]> {
    return this.http.get<Pays[]>(this.linkAllPays).pipe(
      map((paysData: any[]) => {
        const pays: Pays[] = paysData.map((payData) => ({
          nom: payData.name,
          code: payData.alpha2Code,
        }));
        this.allPays.next(pays);
        return pays;
      })
    );
  }
}
