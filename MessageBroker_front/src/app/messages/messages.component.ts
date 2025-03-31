import { TitleCasePipe } from '@angular/common';
import { Component, computed, effect, input, InputSignal, Signal, signal, untracked, WritableSignal } from '@angular/core';
import { Channel, ChannelsService } from '../channels/channels.service';
import { ProducersService } from '../producers/producers.service';
import { ConsumersService } from '../consumers/consumers.service';
import { ProducersComponent } from '../producers/producers.component';
import { ChannelsComponent } from '../channels/channels.component';
import { ConsumersComponent } from '../consumers/consumers.component';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrl: './messages.component.css',
  imports: [TitleCasePipe, ProducersComponent, ChannelsComponent, ConsumersComponent]
})
export class MessagesComponent {

  resourceInput: InputSignal<string> = input<string>('');
  idInput: InputSignal<string> = input<string>('');

  // public producers_id: string[] = [];
  // public channels_id: string[] = [];
  // public consummers_id: string[] = [];

  // public channelSignal: WritableSignal<Channel[]> = signal<Channel[]>([]);
  // public channels_id: Signal<string[]> = computed(() => this.channelSignal().map(c => c.id));
  // public test: Signal<string[]> = computed(() => this.channelSignal().map(c => c.id));
  // public test = computed(() => this.channelSignal().map(c => console.log(c)));
  // public test: Signal<string[]> = computed(() => this.channelSignal().map(c => c.id));
  // public channels_id: string[] = computed(() => this.channelSignal().map(c => c.id))();

  // private test:WritableSignal
  public channelSignal: WritableSignal<Channel[]> = signal<Channel[]>([]);

  public channels_id: Signal<string[]> = computed(() => this.channelSignal().map(c => c.id));
  public producers_id: WritableSignal<string[]> = signal<string[]>([]);
  public consumers_id: WritableSignal<string[]> = signal<string[]>([]);

  constructor(private channelsService: ChannelsService, private producersService: ProducersService, private consumersService: ConsumersService) {
    // this.test = computed(() => this.channelSignal().map(c => console.log(c.id)));

    effect(() => {
      let resource: string = this.resourceInput();
      let id: string = this.idInput();

      // untracked(() => {
      console.log("An EFFECT !!");

      this.channelSignal.set([]);

      switch (resource) {
        case 'producers':
          console.log(resource);
          break;
        case 'channels':
          console.log(resource);
          this.channelsService.getChannel(signal<boolean>(false), signal<boolean>(false), this.channelSignal, id);
          break;
        case 'consumers':
          console.log(resource);
          break;
      }
      // });
    });

    // effect(() => {
    //   let resource: string = this.resource();
    //   let id: string = this.id();

    //   untracked(() => {
    //     console.log("A CLICK : " + resource + " " + id);
    //     console.log("channelSignal");
    //     console.log(this.channelSignal);

    //     console.log("channel_id");
    //     console.log(this.channels_id);

    //     this.producers_id = [];
    //     // this.channels_id = [];
    //     this.consummers_id = [];

    //     this.channelSignal.set([]);
    //     // this.channelSignal.update(c => {
    //     //   while (c.length > 0)
    //     //     c.pop();
    //     //   return c;
    //     // });
    //     // this.channels_id = computed(() => this.channelSignal().map(c => c.id));

    //     // console.log(this.channelSignal);

    //     switch (resource) {
    //       case 'producers':
    //         console.log("producers");
    //         break;
    //       case 'channels':
    //         // this.channels_id.push(id);
    //         this.channelsService.getChannel(signal<boolean>(false), signal<boolean>(false), this.channelSignal, id);
    //         // console.log(this.channels_id);
    //         break;
    //       case 'consumers':
    //         console.log("consumers");
    //         break;
    //       default:
    //         console.log('Default');
    //         break;
    //     };
    //   });


    // });

    // Channel
    // effect(() => {
    //   console.log("Effect");
    //   // this.channelSignal().map(c => console.log(c.id));
    //   console.log(this.channelSignal());
    //   this.channelSignal().forEach(c => console.log(c));
    // });
    // effect(() => {
    //   let channels: Channel[] = this.channelSignal();
    //   console.log(channels);
    //   console.log(this.channelSignal().length);
    //   if (channels.length > 0) {
    //     let channel: Channel = this.channelSignal()[0];
    //     console.log(channel);
    //     this.producers_id = channel.producers_id;
    //     this.consummers_id.push(channel.consumer_id);
    //   }
    // });
  }

}
