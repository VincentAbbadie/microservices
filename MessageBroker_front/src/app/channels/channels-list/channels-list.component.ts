import { Component, Input, signal, WritableSignal } from '@angular/core';
import { Channel, ChannelsService } from '../channels.service';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-channels-list',
  templateUrl: './channels-list.component.html',
  styleUrl: './channels-list.component.css',
  providers: [ChannelsService],
  imports: [RouterLink, RouterLinkActive]
})
export class ChannelsListComponent {

  public channelErrorSignal: WritableSignal<boolean> = signal<boolean>(false);
  public channelLoadingSignal: WritableSignal<boolean> = signal<boolean>(true);
  public channelSignal: WritableSignal<Channel[]> = signal<Channel[]>([]);

  constructor(private channelsService: ChannelsService) { }

  @Input() set ids(channels_id: string[] | undefined) {
    if (!channels_id)
      this.channelsService.getAllChannels(this.channelErrorSignal, this.channelLoadingSignal, this.channelSignal);
    else if (channels_id.length == 0) {
      this.channelLoadingSignal.set(false);
      this.channelSignal.set([]);
    } else {
      this.channelSignal.set([]);
      channels_id.map(id => this.channelsService.getChannel(this.channelErrorSignal, this.channelLoadingSignal, this.channelSignal, id));
    }
  }
}
