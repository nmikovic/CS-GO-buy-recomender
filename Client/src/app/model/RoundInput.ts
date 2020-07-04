import {Map as Mapa} from './Map';
import {Side} from './Side';
import {Player} from './Player';
import {Armament} from './Armament';
import {BuyOptions} from './BuyOptions';
import {Tactic} from './Tactic';

export interface RoundInput {
  map: Mapa;
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

  /*private Map map;
  private Side teamSide;
  private ArrayList<Player> players;
  private HashMap<String, ArrayList<Armament>> armaments;
  private HashMap<String, Integer> cash;
  private Boolean wonPreviousRound;
  private BuyOptions previousTeamState;
  private BuyOptions previousOpponentsState;
  private Tactic tactic;
  private BuyOptions currentTeamState;

  private Boolean opponentHasAWP;
  */
}
