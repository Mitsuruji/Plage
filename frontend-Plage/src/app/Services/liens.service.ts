import { LienDeParente } from '../models/lien-de-parente.model';
import { Injectable } from '@angular/core';
import { map, Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class LiensService {
  private liens = new Subject<LienDeParente[]>();
  private linkLien = 'http://localhost:8080/api/lien-de-parente';

  constructor(private http: HttpClient) {}

  liens$ = this.liens.asObservable();

  getAllLiens(): Observable<LienDeParente[]> {
    return this.http.get<LienDeParente[]>(this.linkLien).pipe(
      map((lien: LienDeParente[]) => {
        this.liens.next(lien);
        return lien;
      })
    );
  }
}
