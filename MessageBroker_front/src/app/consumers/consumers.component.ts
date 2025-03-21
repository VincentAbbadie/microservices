import { Component, OnInit, signal, WritableSignal } from '@angular/core';
import { AsyncPipe } from '@angular/common';
import { Consumer, ConsumersService } from './consumers.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-consumers',
  templateUrl: './consumers.component.html',
  styleUrl: './consumers.component.css',
  providers: [ConsumersService]
})
export class ConsumersComponent{

  public consumerErrorSignal:WritableSignal<boolean>=signal(false);
  public consumerLoadingSignal:WritableSignal<boolean>=signal(true);
  public consumerSignal:WritableSignal<Consumer[]>=signal([]);

  constructor(private consumersService:ConsumersService){
    this.consumersService.getAllConsumers(this.consumerErrorSignal, this.consumerLoadingSignal, this.consumerSignal);
  }

}
