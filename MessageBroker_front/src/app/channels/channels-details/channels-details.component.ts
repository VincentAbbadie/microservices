import { Component, computed, Input, Signal, signal, WritableSignal } from '@angular/core';
import { ChannelsListComponent } from "../channels-list/channels-list.component";
import { ConsumersListComponent } from "../../consumers/consumers-list/consumers-list.component";
import { ProducersListComponent } from "../../producers/producers-list/producers-list.component";
import { Channel, ChannelsService } from '../channels.service';

@Component({
  selector: 'app-channels-details',
  imports: [ChannelsListComponent, ConsumersListComponent, ProducersListComponent],
  templateUrl: './channels-details.component.html',
  styleUrl: './channels-details.component.css'
})
export class ChannelsDetailsComponent {

  public channelIdSignal: WritableSignal<string[]> = signal<string[]>([]);
  public channelSignal: WritableSignal<Channel[]> = signal<Channel[]>([]);
  public consumerIdSignal: Signal<string[]> = computed(() => {
    if (this.channelSignal().length > 0)
      return [this.channelSignal()[0].consumer_id];
    else
      return [];
  });
  public producerIdSignal: Signal<string[]> = computed(() => {
    if (this.channelSignal().length > 0)
      return this.channelSignal()[0].producers_id;
    else
      return [];
  });


  @Input() set channelId(channel_id: string) {
    this.channelIdSignal.set([channel_id]);
    this.channelSignal.set([]);
    this.channelsService.getChannel(signal<boolean>(false), signal<boolean>(false), this.channelSignal, channel_id);
  }

  constructor(private channelsService: ChannelsService) { }

}
