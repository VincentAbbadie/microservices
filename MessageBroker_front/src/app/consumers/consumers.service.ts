import { HttpClient } from '@angular/common/http';
import { Injectable, WritableSignal } from '@angular/core';
import { delay, Observable, retry, tap } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ConsumersService {

  constructor(private httpClient:HttpClient) { }

  public getAllConsumers(consumerErrorSignal:WritableSignal<boolean>, consumerLoadingSignal:WritableSignal<boolean>, consumerSignal:WritableSignal<Consumer[]>):void{
    consumerErrorSignal.set(false);
    consumerLoadingSignal.set(true);
    this.httpClient.get<Consumer[]>(environment.apiUrl+environment.consumersEndPoint)
      .pipe(
        tap({
          error:()=>consumerErrorSignal.set(true)
        }),
        retry({delay:5000})
      ).subscribe({
        next:(value)=>consumerSignal.set(value),
        complete:()=>{
          consumerErrorSignal.set(false);
          consumerLoadingSignal.set(false);
    }});
  }
}

export interface Consumer{
  id:string,
  name:string
}