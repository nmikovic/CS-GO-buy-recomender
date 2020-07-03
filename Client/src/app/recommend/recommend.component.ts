import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MapEnum} from '../model/Map';

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

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
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

}
