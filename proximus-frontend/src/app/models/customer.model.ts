export class Customer {
  public constructor(init?: Partial<Customer>) {
      Object.assign(this, init);
  }
  id: string;
  name: string;
  email: string;
  phone: string;
  age: number;
}
