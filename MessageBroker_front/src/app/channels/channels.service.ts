import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChannelsService {

  constructor(private httpClient:HttpClient) { }

  public getAllChannels():Observable<Channel[]>{
    return this.httpClient.get<Channel[]>(environment.apiUrl+environment.channelsEndPoint);
  }

}

export interface Channel{
  id:string,
  name:string
}
