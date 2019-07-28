import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Customer } from 'src/app/models/customer.model';
import { Subs } from '../models/subs.model';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private CUSTOMER_ENDPOINT = `${environment.settings.API.endpoint}/customer`;

  constructor(private http: HttpClient) { }

  public findAll(): Promise<Array<Customer>> {
    return this.http.get<Array<Customer>>(this.CUSTOMER_ENDPOINT).toPromise();
  }

  public findById(id: string): Promise<Customer> {
    return this.http.get<Customer>(`${this.CUSTOMER_ENDPOINT}/${id}`).toPromise();
  }

  public create(customer: Customer): Promise<Subs> {
    return this.http.post<Subs>(this.CUSTOMER_ENDPOINT, customer).toPromise();
  }

  public update(id: string, customer: Customer): Promise<Customer> {
    return this.http.put<Customer>(`${this.CUSTOMER_ENDPOINT}/${id}`, customer).toPromise();
  }

  public delete(id: string): Promise<Subs> {
    return this.http.delete<Subs>(`${this.CUSTOMER_ENDPOINT}/${id}`).toPromise();
  }
}
