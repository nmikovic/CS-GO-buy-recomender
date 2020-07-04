import {Map} from './Map';
import {Side} from './Side';
import {Player} from './Player';
import {BuyOptions} from './BuyOptions';
import {Tactic} from './Tactic';

export interface RoundInput {
  map: Map;
  teamSide: Side;
  players: Player[];
  armaments: {};
  cash: {};
  wonPreviousRound: boolean;
  previousTeamState: BuyOptions;
  previousOpponentsState: BuyOptions;
  tactic: Tactic;
  currentTeamState: BuyOptions;
  opponentHasAWP: boolean;
}
