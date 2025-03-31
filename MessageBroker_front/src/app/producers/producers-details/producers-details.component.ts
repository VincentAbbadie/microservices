import { Component, computed, Input, Signal, signal, WritableSignal } from '@angular/core';
import { ChannelsListComponent } from '../../channels/channels-list/channels-list.component';
import { ProducersListComponent } from '../producers-list/producers-list.component';
import { ConsumersListComponent } from '../../consumers/consumers-list/consumers-list.component';
import { Producer, ProducersService } from '../producers.service';
import { ChannelsService } from '../../channels/channels.service';

@Component({
  selector: 'app-producers-details',
  imports: [ChannelsListComponent, ProducersListComponent, ConsumersListComponent],
  templateUrl: './producers-details.component.html',
  styleUrl: './producers-details.component.css'
})
export class ProducersDetailsComponent {

  public producerIdSignal: WritableSignal<string[]> = signal<string[]>([]);
  public producerSignal: WritableSignal<Producer[]> = signal<Producer[]>([]);
  public channelsIdSignal: Signal<string[]> = computed(() => {
    if (this.producerSignal().length > 0) {
      return this.producerSignal()[0].channels_id;
    } else
      return [];
  });

  @Input() set producerId(producer_id: string) {
    this.producerIdSignal.set([producer_id]);
    this.producerSignal.set([]);
    this.producersService.getProducer(signal<boolean>(false), signal<boolean>(false), this.producerSignal, producer_id);
  }

  constructor(private producersService: ProducersService, private channelsService: ChannelsService) { }

}
