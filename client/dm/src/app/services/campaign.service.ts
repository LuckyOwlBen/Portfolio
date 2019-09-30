import {Injectable} from '@angular/core';
import {Campaign} from '../models/Campaign';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';

// Base URL
const apiUrl = 'http://ec2-18-223-30-39.us-east-2.compute.amazonaws.com:8089/P2/campaigns/';
// const apiUrl = 'http://localhost:8080/P2/campaigns/';

// HTTP options
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  responseType: 'text' as 'json'
};

@Injectable({
  providedIn: 'root'
})
export class CampaignService {
  currentCampaign: Campaign;

  constructor(
    private http: HttpClient
  ) {}

  getCampaignsByUser(userId: number) {
    return this.http.get<Campaign[]>(apiUrl + '/user/' + userId);
  }

  getCampaign(campaignId: number) {
    return this.http.get<Campaign>(apiUrl + '/campaign/' + campaignId);
  }

  saveCampaign(campaign) {
    return this.http.post(
      apiUrl + '/add',
      campaign, httpOptions
    ).pipe(map(res => {
      return res;
    }));
  }

  updateCampaign(campaign) {
    return this.http.post(
      apiUrl + '/update',
      campaign, httpOptions
    ).pipe(map(res => {
      return res;
    }));
  }

  deleteCampaign(campaignId) {
    return fetch(apiUrl + 'delete/' + campaignId, {
      method: 'POST',
      body: null
    }).then(res => {
      return res;
    });
  }

  setCurrentCampaign(campaign: Campaign) {
    this.currentCampaign = campaign;
  }
}
