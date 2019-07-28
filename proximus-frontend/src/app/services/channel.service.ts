import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Channel } from 'src/app/models/channel.model';

@Injectable({
  providedIn: 'root'
})
export class ChannelService {

  private CHANNEL_ENDPOINT = `${environment.settings.API.endpoint}/channel`;

  constructor(private http: HttpClient) { }

  public findAll(): Promise<Array<Channel>>{
    return this.http.get<Array<Channel>>(this.CHANNEL_ENDPOINT).toPromise();
  }

  public findById(id: string): Promise<Channel> {
    return this.http.get<Channel>(`${this.CHANNEL_ENDPOINT}/${id}`).toPromise();
  }

  public create(channel: Channel): Promise<Channel> {
    return this.http.post<Channel>(this.CHANNEL_ENDPOINT, channel).toPromise();
  }

  public update(id: string, channel: Channel): Promise<Channel> {
    return this.http.put<Channel>(`${this.CHANNEL_ENDPOINT}/${id}`, channel).toPromise();
  }

  public delete(id: string): Promise<Channel> {
    return this.http.delete<Channel>(`${this.CHANNEL_ENDPOINT}/${id}`).toPromise();
  }
}
