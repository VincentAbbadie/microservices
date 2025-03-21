import { Component, signal, WritableSignal } from '@angular/core';
import { Channel, ChannelsService } from './channels.service';

@Component({
  selector: 'app-channels',
  templateUrl: './channels.component.html',
  styleUrl: './channels.component.css',
  providers : [ChannelsService]
})
export class ChannelsComponent{

  public channelErrorSignal:WritableSignal<boolean>=signal(false);
  public channelLoadingSignal:WritableSignal<boolean>=signal(true);
  public channelSignal:WritableSignal<Channel[]>=signal([]);

  constructor(private channelsService:ChannelsService){
    this.channelsService.getAllChannels(this.channelErrorSignal, this.channelLoadingSignal, this.channelSignal);
  }

  public selectChannel(channel:Channel):void{
    console.log(channel);
  }

  public deleteChannel(channel:Channel):void{
    console.log(channel);
  }

}
