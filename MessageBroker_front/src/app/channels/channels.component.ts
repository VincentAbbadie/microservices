import { Component, OnInit } from '@angular/core';
import { AsyncPipe } from '@angular/common';
import { Channel, ChannelsService } from './channels.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-channels',
  imports: [AsyncPipe],
  templateUrl: './channels.component.html',
  styleUrl: './channels.component.css',
  providers : [ChannelsService]
})
export class ChannelsComponent implements OnInit{

  public channels$!:Observable<Channel[]>;

  constructor(private channelsService:ChannelsService){}

  ngOnInit(): void {
    this.channels$=this.channelsService.getAllChannels();
  }

}
