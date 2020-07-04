import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Rules} from '../model/Rules';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private httpClient: HttpClient) {
  }

  getFactClasses() {
    return this.httpClient.get('facts');
  }

  getFactContent(name: string) {
    return this.httpClient.get(`facts/${name}`, {responseType: 'text'});
  }

  createRules(rules: Rules) {
    return this.httpClient.post('rules', rules, {responseType: 'text'});
  }
}
