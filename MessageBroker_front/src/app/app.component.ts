import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ChannelsComponent } from "./channels/channels.component";
import { ProducersComponent } from "./producers/producers.component";
import { ConsumersComponent } from "./consumers/consumers.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ChannelsComponent, ProducersComponent, ConsumersComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

}
