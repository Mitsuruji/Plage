import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Pays } from '../models/pays.model';

@Injectable({
  providedIn: 'root',
})
export class PaysService {
  private api = 'https://restcountries.com/v2/all?fields=alpha2Code,name,flags';

  constructor(private http: HttpClient) {}
}

interface Country {
  name: string;
  alpha2Code: string;
  flag: string;
}
