export class Subs {
  public constructor(init?: Partial<Subs>) {
      Object.assign(this, init);
  }
  id: string;
  customerId: string;
  updatedDate?: Date;
  activeChannels: Array<string>;
}
