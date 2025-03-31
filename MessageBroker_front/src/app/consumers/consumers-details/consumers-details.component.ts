import { Component, Input, signal, WritableSignal } from '@angular/core';

@Component({
  selector: 'app-consumers-details',
  imports: [],
  templateUrl: './consumers-details.component.html',
  styleUrl: './consumers-details.component.css'
})
export class ConsumersDetailsComponent {

  public consumerIdSignal: WritableSignal<string> = signal<string>('');

  @Input() set consumerId(consumer_id: string) {
    this.consumerIdSignal.set(consumer_id);
  }

}
