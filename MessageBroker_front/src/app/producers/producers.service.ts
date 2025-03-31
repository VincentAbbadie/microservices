import { HttpClient } from '@angular/common/http';
import { Injectable, Signal, signal, WritableSignal } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable, retry, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProducersService {

  constructor(private httpClient: HttpClient) { }

  public getAllProducers(producerErrorSignal: WritableSignal<boolean>, producerLoadingSignal: WritableSignal<boolean>, producerSignal: WritableSignal<Producer[]>): void {
    producerErrorSignal.set(false);
    producerLoadingSignal.set(true);

    this.httpClient.get<Producer[]>(environment.apiUrl + environment.producersEndPoint)
      .pipe(
        tap({
          error: () => producerErrorSignal.set(true)
        }),
        retry({ delay: 5000 })
      ).subscribe({
        next: (value) => producerSignal.set(value),
        complete: () => {
          producerErrorSignal.set(false);
          producerLoadingSignal.set(false);
        }
      });
  }

  public getProducer(producerErrorSignal: WritableSignal<boolean>, producerLoadingSignal: WritableSignal<boolean>, producerSignal: WritableSignal<Producer[]>, producerId: string): void {
    producerErrorSignal.set(false);
    producerLoadingSignal.set(true);

    let producers: Producer[] = producerSignal();

    this.httpClient.get<Producer>(environment.apiUrl + environment.producersEndPoint + "/" + producerId)
      .pipe(
        tap({
          error: () => producerErrorSignal.set(true)
        }),
        retry({ delay: 5000 })
      ).subscribe({
        next: (value) => producerSignal.set(producers.concat(producers, value)),
        complete: () => {
          producerErrorSignal.set(false);
          producerLoadingSignal.set(false);
        }
      });
  }
}

export interface Producer {
  id: string,
  name: string,
  channels_id: string[]
}