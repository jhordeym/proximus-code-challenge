import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { CustomerDetailComponent } from './components/customer-detail/customer-detail.component';
import { ChannelDetailComponent } from './components/channel-detail/channel-detail.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'customer/:id', component: CustomerDetailComponent},
  {path: 'channel/:id', component: ChannelDetailComponent},
  {path: 'register-new-customer', component: CustomerDetailComponent},
  {path: 'register-new-channel', component: ChannelDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
