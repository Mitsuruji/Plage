import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { JwtUtilsService } from './jwt-utils.service';

@Injectable({
  providedIn: 'root',
})
export class AuthentificationService {
  link = 'http://localhost:8080/api/utilisateur/authentification';
  linkRegister = 'http://localhost:8080/api/utilisateur/inscription';

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

  register(f: any) {
    return this.http.post(this.link, f);
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
