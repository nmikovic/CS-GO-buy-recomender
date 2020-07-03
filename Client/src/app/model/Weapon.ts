import {Armament} from './Armament';

export interface Weapon extends Armament{
  scope: boolean;
  killBonus: number;
  helmetHeadshotKill: boolean;
}
