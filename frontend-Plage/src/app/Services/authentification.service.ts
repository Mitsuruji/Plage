import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Concessionnaire } from '../models/concessionnaire.model';
import { Locataire } from '../models/locataire.model';
import { JwtUtilsService } from './jwt-utils.service';

@Injectable({
  providedIn: 'root',
})
export class AuthentificationService {
  link = 'http://localhost:8080/api/utilisateur/authentification';

  constructor(
    private http: HttpClient,
    private jwtUtilsService: JwtUtilsService
  ) {}

  connect(identifiants: any) {
    return this.http.post(this.link, identifiants);
  }

  disconnect() {
    localStorage.removeItem('myToken');
  }

  isConnected() {
    let token = localStorage.getItem('myToken');
    if (token) return true;
    else return false;
  }

  userType() {
    let token = localStorage.getItem('myToken')!;
    const jws = this.jwtUtilsService.getDecodedAccessToken(token);

    if (token && jws.type == 'Concessionnaire') {
      return 'Concessionnaire';
    } else if (token && jws.type == 'Locataire') {
      return 'Locataire';
    } else {
      return 'Unknown';
    }
  }
}
