import { Component, OnInit } from '@angular/core';
import { ChannelService } from 'src/app/services/channel.service';
import { ActivatedRoute } from '@angular/router';
import { Channel } from 'src/app/models/channel.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SubsService } from 'src/app/services/subs.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-channel-detail',
  templateUrl: './channel-detail.component.html',
  styleUrls: ['./channel-detail.component.sass']
})
export class ChannelDetailComponent implements OnInit {

  channel: Channel;
  resolutions: string[] = ['NORMAL', 'HD', 'FULLHD', 'ULTRAHD'];
  channelEditForm: FormGroup = this.fb.group({
    name: ['', Validators.required],
    number: [0, [Validators.required, Validators.pattern('[0-9 ]*')]],
    resolution: this.resolutions[0],
    activeByDefault: false
  });

  constructor(
    private route: ActivatedRoute,
    private channelService: ChannelService,
    private subsService: SubsService,
    private fb: FormBuilder,
    private snackbar: MatSnackBar) { }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if(id) {
      this.channelService.findById(id)
      .then(res => {
        // console.log(res);
        this.channel = res;

        this.channelEditForm = this.fb.group({
          name: [res.name, Validators.required],
          number: [res.number, [Validators.required, Validators.pattern('[0-9 ]*')]],
          resolution: [res.resolution],
          activeByDefault: [res.activeByDefault]
        });
      });
    } else { }
  }

  update() {
    const formData = this.channelEditForm.value;
    // console.log(formData);
    if (this.channelEditForm.valid) {
      if (this.channel) {
        this.channelService.update(this.channel.id, formData)
        .then(res => this.snackbar.open('Channel: "' + res.name + '" updated!', 'Close', { duration: 3000 }),
        error => this.snackbar.open('Could not update!', 'Close', { duration: 3000 }));
      } else {
        this.channelService.create(formData)
        .then(res => this.snackbar.open('Channel: "' + res.name + '" registered!', 'Close', { duration: 3000 }),
        error => this.snackbar.open('Could not register!', 'Close', { duration: 3000 }));
      }
    }
  }

  delete() {
    this.channelService.delete(this.channel.id)
      .then(res => this.snackbar.open('Channel: "' + res.name + '" deleted!', 'Close', { duration: 3000 }),
      error => this.snackbar.open('Could not delete!', 'Close', { duration: 3000 }));
  }

}
