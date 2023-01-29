import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpHeaders,
  HTTP_INTERCEPTORS
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AccessTokenInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    console.log(request);

    let token = localStorage.getItem('myToken');
    if (token) {
      let cloneRequest = request.clone({
        headers: new HttpHeaders().set('Authorization', 'bearer ' + token),
      });
      return next.handle(cloneRequest);
    } else {
      return next.handle(request);
    }
  }
}

export const tokenInterceptorProvider = {
  provide: HTTP_INTERCEPTORS,
  useClass: AccessTokenInterceptor,
  multi: true,
};

