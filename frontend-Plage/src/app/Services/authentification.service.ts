import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
  link = 'http://localhost:8080/api/utilisateur/authentification';

  constructor(private http: HttpClient) {}

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

}
