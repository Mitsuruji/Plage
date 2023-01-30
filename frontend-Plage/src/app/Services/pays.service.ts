import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Pays } from '../model/pays.model';

@Injectable({
  providedIn: 'root',
})
export class PaysService {
  private api = 'https://restcountries.com/v2/all?fields=name;alpha2Code;flag';

  constructor(private http: HttpClient) {}
}

interface Country {
  name: string;
  alpha2Code: string;
  flag: string;
}
