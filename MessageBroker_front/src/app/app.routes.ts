import { Routes } from '@angular/router';
import { ChannelsDetailsComponent } from './channels/channels-details/channels-details.component';
import { ProducersDetailsComponent } from './producers/producers-details/producers-details.component';
import { ConsumersDetailsComponent } from './consumers/consumers-details/consumers-details.component';

export const routes: Routes = [
    { path: 'channels/:channelId', component: ChannelsDetailsComponent },
    { path: 'producers/:producerId', component: ProducersDetailsComponent },
    { path: 'consumers/:consumerId', component: ConsumersDetailsComponent }
];
