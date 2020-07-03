import {Side} from './Side';
import {ArmamentType} from './ArmamentType';
export interface Armament {
  playerStatus: number;
  name: string;
  price: number;
  type: ArmamentType;
  side: Side;
}
