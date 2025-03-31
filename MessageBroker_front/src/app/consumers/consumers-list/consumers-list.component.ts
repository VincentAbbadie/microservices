import { Component, Input, signal, WritableSignal } from '@angular/core';
import { Consumer, ConsumersService } from '../consumers.service';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-consumers-list',
  templateUrl: './consumers-list.component.html',
  styleUrl: './consumers-list.component.css',
  providers: [ConsumersService],
  imports: [RouterLink, RouterLinkActive]
})
export class ConsumersListComponent {

  public consumerErrorSignal: WritableSignal<boolean> = signal<boolean>(false);
  public consumerLoadingSignal: WritableSignal<boolean> = signal<boolean>(true);
  public consumerSignal: WritableSignal<Consumer[]> = signal<Consumer[]>([]);

  constructor(private consumersService: ConsumersService) { }

  @Input() set ids(consumers_id: string[] | undefined) {
    if (!consumers_id)
      this.consumersService.getAllConsumers(this.consumerErrorSignal, this.consumerLoadingSignal, this.consumerSignal);
    else if (consumers_id.length == 0) {
      this.consumerLoadingSignal.set(false);
      this.consumerSignal.set([]);
    } else {
      this.consumerSignal.set([]);
      consumers_id.map(id => this.consumersService.getConsumer(this.consumerErrorSignal, this.consumerLoadingSignal, this.consumerSignal, id));
    }
  }

}
