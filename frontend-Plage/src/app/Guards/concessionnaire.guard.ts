import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { Observable } from 'rxjs';
import { JwtUtilsService } from '../services/jwt-utils.service';
import { Concessionnaire } from '../models/concessionnaire.model';

@Injectable({
  providedIn: 'root',
})
export class ConcessionnaireGuard implements CanActivate {
  constructor(private jwtUtilsService: JwtUtilsService) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
    let token = localStorage.getItem('myToken')!;
    const jws = this.jwtUtilsService.getDecodedAccessToken(token);

    if (token && jws.type == 'Concessionnaire') return true;
    else return false;
  }
}
