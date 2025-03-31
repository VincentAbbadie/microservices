import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ChannelsListComponent } from "./channels/channels-list/channels-list.component";
import { ConsumersListComponent } from "./consumers/consumers-list/consumers-list.component";
import { ProducersListComponent } from './producers/producers-list/producers-list.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ChannelsListComponent, ConsumersListComponent, ProducersListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

}
