import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ChannelService } from 'src/app/services/channel.service';
import { Channel } from 'src/app/models/channel.model';
import { SubsService } from 'src/app/services/subs.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-channels-list',
  templateUrl: './channels-list.component.html',
  styleUrls: ['./channels-list.component.sass']
})
export class ChannelsListComponent implements OnInit {

  channels: Array<Channel>;
  subbed: Array<Channel>;
  available: Array<Channel>;

  arrayOfChannels: Array<Array<Channel>> = [];
  arrayOfTitles: string[] = [];

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private channelServ: ChannelService,
    private subService: SubsService,
    private snackbar: MatSnackBar
    ) { }

  ngOnInit() {
    const path = this.route.snapshot.routeConfig.path;
    // console.log(path);
    if (path === 'home') {
      this._loadAll();
    } else if (path === 'register-new-customer' || path === 'register-new-channel') {
      // do nothing
    } else {
      const id = this.route.snapshot.paramMap.get('id');
      if (id) {
        this.subService.findSubbedById(id).then(
          res => {
            // console.log(res);
            this.subbed = res;
            this.arrayOfChannels.push(res);
            this.arrayOfTitles.push('Subbed Channels');
          }
        );
        this.subService.findAvailableById(id).then(
          res => {
            // console.log(res);
            this.available = res;
            this.arrayOfChannels.push(res);
            this.arrayOfTitles.push('Available Channels');
          }
        );
      } else {
        // do nothing
      }
    }
  }

  clickChannel(c: Channel): void {
    this.router.navigate(['channel/', c.id]);
  }

  private _loadAll() {
    this.channelServ.findAll().then(
      res => {
        // console.log(res);
        this.channels = res;
        this.arrayOfChannels.push(res);
        this.arrayOfTitles.push('All Channels');
      },
      error => this.snackbar.open('Could not load channels!', 'Close', { duration: 3000 }));
  }
}
