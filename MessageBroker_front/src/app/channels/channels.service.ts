import { HttpClient } from '@angular/common/http';
import { Injectable, WritableSignal } from '@angular/core';
import { environment } from '../../environments/environment';
import { retry, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChannelsService {

  constructor(private httpClient:HttpClient) { }

  public getAllChannels(channelErrorSignal:WritableSignal<boolean>, channelLoadingSignal:WritableSignal<boolean>, channelSignal:WritableSignal<Channel[]>):void{
    channelErrorSignal.set(false);
    channelLoadingSignal.set(true);
    this.httpClient.get<Channel[]>(environment.apiUrl+environment.channelsEndPoint)
      .pipe(
        tap({
          error:()=>channelErrorSignal.set(true)
        }),
        retry({delay:5000})
    ).subscribe({
      next:(value)=>channelSignal.set(value),
      complete:()=>{
        channelErrorSignal.set(false);
        channelLoadingSignal.set(false);
    }});

  }

}

export interface Channel{
  id:string,
  name:string
}
