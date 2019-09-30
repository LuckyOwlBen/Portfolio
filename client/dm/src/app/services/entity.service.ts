import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {Entity} from '../models/Entity';

// Base URL
const apiUrl = 'http://ec2-18-223-30-39.us-east-2.compute.amazonaws.com:8089/P2/activeEntity';
// const apiUrl = 'http://localhost:8080/P2/activeEntity';

// HTTP options
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  responseType: 'text' as 'json'
};

@Injectable({
  providedIn: 'root'
})
export class EntityService {

  constructor(
    private http: HttpClient
  ) {}

  loadMonsterVault() {
    const vaultUrl = 'http://ec2-18-223-30-39.us-east-2.compute.amazonaws.com:8089/P2/monsterVault/returnAll';
    return this.http.get<Entity[]>(vaultUrl);
  }

  saveEntity(entity) {
    return this.http.post(
      apiUrl + '/saveEntities', entity, httpOptions
    ).pipe(map(res => {
      return res;
    }));
  }

  deleteEntity(entityId) {
    return fetch(apiUrl + '/delete/' + entityId, {
      method: 'POST',
      body: null
    }).then(res => {
      return res;
    });
  }
}
