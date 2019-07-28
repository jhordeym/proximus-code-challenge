import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Subs } from '../models/subs.model';
import { Channel } from '../models/channel.model';

@Injectable({
  providedIn: 'root'
})
export class SubsService {

  private SUBS_ENDPOINT = `${environment.settings.API.endpoint}/subs`;

  constructor(private http: HttpClient) { }

  public findSubbedById(id: string): Promise<Array<Channel>> {
    return this.http.get<Array<Channel>>(`${this.SUBS_ENDPOINT}/subbed/${id}`).toPromise();
  }

  public findAvailableById(id: string): Promise<Array<Channel>> {
    return this.http.get<Array<Channel>>(`${this.SUBS_ENDPOINT}/available/${id}`).toPromise();
  }

  public subWithoutAppend(
    id: string,
    channels: Array<Channel>): Promise<Subs> {
    return this.http.post<Subs>(`${this.SUBS_ENDPOINT}/${id}`, channels).toPromise();
  }

  public subWithAppend(
    id: string,
    channels: Array<Channel>): Promise<Subs> {
    return this.http.post<Subs>(`${this.SUBS_ENDPOINT}/${id}?append=true`, channels).toPromise();
  }

}
