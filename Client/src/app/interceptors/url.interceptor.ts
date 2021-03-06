import {Injectable} from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';

@Injectable()
export class UrlInterceptor implements HttpInterceptor {
  private readonly baseURL: string;

  constructor() {
    this.baseURL = environment.baseUrl;
  }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    return next.handle(request.clone({url: `${this.baseURL}${request.url}`}));
  }
}
