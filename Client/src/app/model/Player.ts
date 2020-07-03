import {Rank} from './Rank';
import {Score} from './Score';

export interface Player {
  rank: Rank;
  name: string;
  score: Score;
}
