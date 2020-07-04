import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {RoundInput} from '../model/RoundInput';
import {Side} from '../model/Side';
import {Player} from '../model/Player';
import {Armament} from '../model/Armament';
import {ArmamentType} from '../model/ArmamentType';
import {ApiService} from '../services/api.service';

@Component({
  selector: 'app-recommend',
  templateUrl: './recommend.component.html',
  styleUrls: ['./recommend.component.css']
})
export class RecommendComponent implements OnInit {
  defaultData: FormGroup;
  firstPlayerData: FormGroup;
  secondPlayerData: FormGroup;
  thirdPlayerData: FormGroup;
  fourthPlayerData: FormGroup;
  fifthPlayerData: FormGroup;
  maps: string[] = ['CACHE', 'MIRAGE'];
  armamentMap: Map<string, Armament>;

  constructor(private formBuilder: FormBuilder, private apiService: ApiService) {
  }

  ngOnInit(): void {
    this.apiService.getArmaments().subscribe({
      next: (armaments: Map<string, Armament>) => {
        this.armamentMap = armaments;
        console.log(this.armamentMap['AK-47']);
      }
    });
    this.defaultData = this.formBuilder.group({
      mapName: [''],
      teamSide: [''],
      tactic: ['']
    });
    this.firstPlayerData = this.formBuilder.group({
      rank: [''],
      name: [''],
      cash: [''],
      armament: [''],
    });
    this.secondPlayerData = this.formBuilder.group({
      rank: [''],
      name: [''],
      cash: [''],
      armament: [''],
    });
    this.thirdPlayerData = this.formBuilder.group({
      rank: [''],
      name: [''],
      cash: [''],
      armament: [''],
    });
    this.fourthPlayerData = this.formBuilder.group({
      rank: [''],
      name: [''],
      cash: [''],
      armament: [''],
    });
    this.fifthPlayerData = this.formBuilder.group({
      rank: [''],
      name: [''],
      cash: [''],
      armament: [''],
    });
  }

  recommend() {
    const roundInput: RoundInput = {
      map: this.defaultData.controls.mapName.value,
      teamSide: this.defaultData.controls.teamSide.value,
      players: null,
      armaments: null,
      cash: null,
      wonPreviousRound: null,
      previousTeamState: null,
      previousOpponentsState: null,
      tactic: this.defaultData.controls.tactic.value,
      currentTeamState: null,
      opponentHasAWP: null,
    };

    const playerForms = [this.firstPlayerData, this.secondPlayerData, this.thirdPlayerData, this.fourthPlayerData, this.fifthPlayerData];
    const players = [];
    const cash = {};
    const armaments = {};
    playerForms.forEach((form) => {
      // cash
      cash[form.controls.name.value] = form.controls.cash.value as number;
      // player
      const p: Player = {
        rank: form.controls.rank.value,
        name: form.controls.name.value,
        score: null
      };
      players.push(p);

      // armament list
      const armament = [];
      const armamentValues = form.controls.armament.value.split(',');

      armamentValues.forEach((weapon) => {
        armament.push(this.armamentMap[weapon]);
      });

      armaments[form.controls.name.value] =  armament;
    });
    roundInput.players = players;
    roundInput.cash = cash;
    roundInput.armaments = armaments;

    console.log(JSON.stringify(roundInput));

    this.apiService.recommend(roundInput).subscribe({
      next: (result: Map<string, Armament[]>) => {
        console.log(result);
      }
    });


  }

}
