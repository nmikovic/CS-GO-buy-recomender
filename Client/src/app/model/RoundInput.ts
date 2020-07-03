import {MapEnum} from './Map';
import {Side} from './Side';
import {Player} from './Player';
import {Armament} from './Armament';
import {BuyOptions} from './BuyOptions';
import {Tactic} from './Tactic';
export interface RoundInput {
  map: MapEnum;
  teamSide: Side;
  players: Player[];
  armaments: Map<string, Armament[]>;
  cash: Map<string, number>;
  wonPreviousRound: boolean;
  previousTeamState: BuyOptions;
  previousOpponentsState: BuyOptions;
  tactic: Tactic;
  currentTeamState: BuyOptions;
  opponentHasAWP: boolean;
}
