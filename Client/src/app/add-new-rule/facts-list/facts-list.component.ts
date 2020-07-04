import {Component, OnInit} from '@angular/core';
import {ApiService} from '../../services/api.service';
import {SharedService} from '../../services/shared.service';
import {MatSelectChange} from '@angular/material/select';

@Component({
  selector: 'app-facts-list',
  templateUrl: './facts-list.component.html',
  styleUrls: ['./facts-list.component.css']
})
export class FactsListComponent implements OnInit {
  facts: [];

  constructor(private apiService: ApiService, private sharedService: SharedService) {
  }

  ngOnInit(): void {
    this.apiService.getFactClasses().subscribe({
      next: (facts: []) => {
        this.facts = facts;
      }
    });
  }

  selectFact(factName: MatSelectChange) {
    this.sharedService.selectCode(factName.value);
  }

}
