export class Channel {
  public constructor(init?: Partial<Channel>) {
      Object.assign(this, init);
  }
  id: string;
  name: string;
  number: number;
  resolution: string;
  categories: Array<string>;
  activeByDefault: boolean;
}
