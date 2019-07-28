import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/services/customer.service';
import { ActivatedRoute } from '@angular/router';
import { Customer } from 'src/app/models/customer.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SubsService } from 'src/app/services/subs.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.sass']
})
export class CustomerDetailComponent implements OnInit {
  customer: Customer;
  customerEditForm: FormGroup = this.fb.group({
    name: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    phone: ['', [Validators.required, Validators.pattern('[0-9 ]*')]],
    age: ['', [Validators.required, Validators.pattern('[0-9 ]*')]]
  });

  constructor(
    private route: ActivatedRoute,
    private customerService: CustomerService,
    private subsService: SubsService,
    private fb: FormBuilder,
    private snackbar: MatSnackBar) { }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if(id) {
      this.customerService.findById(id)
      .then(res => {
        // console.log(res);
        this.customer = res;

        this.customerEditForm = this.fb.group({
          name: [res.name, Validators.required],
          email: [res.email, [Validators.required, Validators.email]],
          phone: [res.phone, [Validators.required, Validators.pattern('[0-9 ]*')]],
          age: [res.age, [Validators.required, Validators.pattern('[0-9 ]*')]]
        });
      });
    } else { }
  }

  public update() {
    const formData = this.customerEditForm.value;
    // console.log(formData);
    if (this.customerEditForm.valid) {
      if (this.customer) {
        this.customerService.update(this.customer.id, formData)
        .then(res => this.snackbar.open('Customer: "' + res.name + '" updated!', 'Close', { duration: 3000 }),
        error => this.snackbar.open('Could not update!', 'Close', { duration: 3000 }));
      } else {
        this.customerService.create(formData)
        .then(res => this.snackbar.open('Customer: "' + formData.name + '" created!', 'Close', { duration: 3000 }),
        error => this.snackbar.open('Could not register!', 'Close', { duration: 3000 }));
      }
    }
  }

  public delete() {
    this.customerService.delete(this.customer.id)
    .then(res => this.snackbar.open('Customer: "' + this.customer.name + '" deleted!', 'Close', { duration: 3000 }),
    error => this.snackbar.open('Could not delete!', 'Close', { duration: 3000 }));
  }

}
