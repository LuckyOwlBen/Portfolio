import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

// Base URL
const apiUrl = 'http://ec2-18-223-30-39.us-east-2.compute.amazonaws.com:8089/P2/register';
// const apiUrl = 'http://localhost:8080/P2/register';

const httpHeaders = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  responseType: 'text' as 'json'
};

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http: HttpClient) { }

  addNewUser(data) {
    return this.http.post<string>(
    apiUrl, data, httpHeaders,
    );
  }
}
