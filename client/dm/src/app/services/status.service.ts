import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';

// Base URL
const apiUrl = 'http://ec2-18-223-30-39.us-east-2.compute.amazonaws.com:8089/P2/conditions';
// const apiUrl = 'http://localhost:8080/P2/conditions';

@Injectable({
  providedIn: 'root'
})
export class StatusService {
  conditions: string[];

  constructor(
    private http: HttpClient
  ) {}

  getConditions() {
    return this.http.get<string[]>(apiUrl + '/all').pipe(
      map(condition => {
        return condition;
      }));
}
}
