import { Component, OnInit, signal, WritableSignal } from '@angular/core';
import { Observable } from 'rxjs';
import { Producer, ProducersService } from './producers.service';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-producers',
  templateUrl: './producers.component.html',
  styleUrl: './producers.component.css',
  providers: [ProducersService]
})
export class ProducersComponent{

  public producerErrorSignal:WritableSignal<boolean>=signal(false);
  public producerLoadingSignal:WritableSignal<boolean>=signal(true);
  public producerSignal:WritableSignal<Producer[]>=signal([]);

  constructor(private producersService:ProducersService){
    this.producersService.getAllProducers(this.producerErrorSignal, this.producerLoadingSignal, this.producerSignal);
  }

}
