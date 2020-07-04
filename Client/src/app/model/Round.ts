import {Side} from './Side';
import {BuyOptions} from './BuyOptions';
import {Tactic} from './Tactic';
import {MapEnum} from './MapEnum';
export interface Round {
  number: number;
  teamSide: Side;
  wonPreviousRound: boolean;
  previousTeamState: BuyOptions;
  previousOpponentsState: BuyOptions;
  tactic: Tactic;
  currentTeamState: BuyOptions;
  opponentHasAWP: boolean;
  map: MapEnum;
}
