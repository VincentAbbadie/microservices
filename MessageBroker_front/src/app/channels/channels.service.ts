import { HttpClient } from '@angular/common/http';
import { Injectable, signal, Signal, WritableSignal } from '@angular/core';
import { environment } from '../../environments/environment';
import { retry, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChannelsService {

  constructor(private httpClient: HttpClient) { }

  public getAllChannels(channelErrorSignal: WritableSignal<boolean>, channelLoadingSignal: WritableSignal<boolean>, channelSignal: WritableSignal<Channel[]>): void {
    channelErrorSignal.set(false);
    channelLoadingSignal.set(true);
    this.httpClient.get<Channel[]>(environment.apiUrl + environment.channelsEndPoint)
      .pipe(
        tap({
          error: () => channelErrorSignal.set(true)
        }),
        retry({ delay: 5000 })
      ).subscribe({
        next: (value) => channelSignal.set(value),
        complete: () => {
          channelErrorSignal.set(false);
          channelLoadingSignal.set(false);
        }
      });
  }

  public getChannel(channelErrorSignal: WritableSignal<boolean>, channelLoadingSignal: WritableSignal<boolean>, channelSignal: WritableSignal<Channel[]>, channelId: string): void {
    channelErrorSignal.set(false);
    channelLoadingSignal.set(true);

    let channels: Channel[] = channelSignal();

    this.httpClient.get<Channel>(environment.apiUrl + environment.channelsEndPoint + "/" + channelId)
      .pipe(
        tap({
          error: () => channelErrorSignal.set(true)
        }),
        retry({ delay: 5000 })
      ).subscribe({
        next: (value) => {
          channelSignal.set(channels.concat(channels, value));
        },
        complete: () => {
          channelErrorSignal.set(false);
          channelLoadingSignal.set(false);
        }
      });
  }

}

export interface Channel {
  id: string;
  name: string;
  producers_id: string[];
  consumer_id: string;
}
