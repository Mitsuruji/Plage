import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { JwtUtilsService } from './../Services/jwt-utils.service';

@Injectable({
  providedIn: 'root'
})
export class ConcessionnaireGuard implements CanActivate {

  constructor(private jwtUtilsService: JwtUtilsService){}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
    let token = localStorage.getItem('myToken')!;
    console.log(this.jwtUtilsService.getDecodedAccessToken(token));
    
    if (token) return true;
    else return false;
  }
  
}
