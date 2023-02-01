import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable, Subject } from 'rxjs';
import { Pays } from '../models/pays.model';

@Injectable({
  providedIn: 'root',
})
export class PaysService {
  //   private api = 'https://restcountries.com/v2/all?fields=alpha2Code,name,flags';

  //   constructor(private http: HttpClient) {}
  // }

  // interface Country {
  //   name: string;
  //   alpha2Code: string;
  //   flag: string;
  // }{
  private allPays = new Subject<Pays[]>();
  // private linkAllPays = 'http://localhost:8080/api/pays';
  private linkAllPays =
    'https://restcountries.com/v2/all?fields=alpha2Code,name';

  constructor(private http: HttpClient) {}

  pays = this.allPays.asObservable();

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
