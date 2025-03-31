import { Component, Input, signal, WritableSignal } from '@angular/core';
import { Producer, ProducersService } from '../producers.service';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-producers-list',
  templateUrl: './producers-list.component.html',
  styleUrl: './producers-list.component.css',
  providers: [ProducersService],
  imports: [RouterLink, RouterLinkActive]
})
export class ProducersListComponent {

  public producerErrorSignal: WritableSignal<boolean> = signal<boolean>(false);
  public producerLoadingSignal: WritableSignal<boolean> = signal<boolean>(true);
  public producerSignal: WritableSignal<Producer[]> = signal<Producer[]>([]);

  constructor(private producersService: ProducersService) { }

  @Input() set ids(producers_id: string[] | undefined) {
    if (!producers_id)
      this.producersService.getAllProducers(this.producerErrorSignal, this.producerLoadingSignal, this.producerSignal);
    else if (producers_id.length == 0) {
      this.producerLoadingSignal.set(false);
      this.producerSignal.set([]);
    } else {
      this.producerSignal.set([]);
      producers_id.map(id => this.producersService.getProducer(this.producerErrorSignal, this.producerLoadingSignal, this.producerSignal, id));
    }
  }

}
