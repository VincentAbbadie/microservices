import { HttpClient } from '@angular/common/http';
import { Injectable, signal, Signal, WritableSignal } from '@angular/core';
import { retry, tap } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ConsumersService {

  constructor(private httpClient: HttpClient) { }

  public getAllConsumers(consumerErrorSignal: WritableSignal<boolean>, consumerLoadingSignal: WritableSignal<boolean>, consumerSignal: WritableSignal<Consumer[]>): void {
    consumerErrorSignal.set(false);
    consumerLoadingSignal.set(true);
    this.httpClient.get<Consumer[]>(environment.apiUrl + environment.consumersEndPoint)
      .pipe(
        tap({
          error: () => consumerErrorSignal.set(true)
        }),
        retry({ delay: 5000 })
      ).subscribe({
        next: (value) => consumerSignal.set(value),
        complete: () => {
          consumerErrorSignal.set(false);
          consumerLoadingSignal.set(false);
        }
      });
  }

  public getConsumer(consumerErrorSignal: WritableSignal<boolean>, consumerLoadingSignal: WritableSignal<boolean>, consumerSignal: WritableSignal<Consumer[]>, consumerId: string): void {
    consumerErrorSignal.set(false);
    consumerLoadingSignal.set(true);

    this.httpClient.get<Consumer>(environment.apiUrl + environment.consumersEndPoint + "/" + consumerId)
      .pipe(
        tap({
          error: () => consumerErrorSignal.set(true)
        }),
        retry({ delay: 5000 })
      ).subscribe({
        next: (value) => consumerSignal.update(c => {
          c.push(value);
          return c;
        }),
        complete: () => {
          consumerErrorSignal.set(false);
          consumerLoadingSignal.set(false);
        }
      });
  }

}

export interface Consumer {
  id: string;
  name: string;
  channels_id: string[];
}