import {Injectable} from '@angular/core';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  private code: Subject<string> = new Subject<string>();

  constructor() {
  }

  selectCode(code: string) {
    this.code.next(code);
  }

  getCode() {
    return this.code.asObservable();
  }
}
