import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ChannelService } from 'src/app/services/channel.service';
import { CustomerService } from 'src/app/services/customer.service';
import { SubsService } from 'src/app/services/subs.service';
import { Channel } from 'src/app/models/channel.model';
import { Customer } from 'src/app/models/customer.model';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.sass']
})
export class HomeComponent implements OnInit {

  customers: Array<Customer>;

  constructor(
    private router: Router,
    private customerServ: CustomerService,
    private subsServ: SubsService,
    private snackbar: MatSnackBar) { }

  ngOnInit() {
    this.customerServ.findAll().then(
      res => {
        // console.log(res);
        this.customers = res;
      },
      error => this.snackbar.open('Could not load customers!', 'Close', { duration: 3000 }));
  }

  clickCustomer(c: Customer): void {
    this.router.navigate(['customer/', c.id]);
  }

}
