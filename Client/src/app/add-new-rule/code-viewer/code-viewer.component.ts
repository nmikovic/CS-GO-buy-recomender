import {Component, OnInit} from '@angular/core';
import {ApiService} from '../../services/api.service';
import {SharedService} from '../../services/shared.service';

@Component({
  selector: 'app-code-viewer',
  templateUrl: './code-viewer.component.html',
  styleUrls: ['./code-viewer.component.css']
})
export class CodeViewerComponent implements OnInit {
  code: string;

  constructor(private apiService: ApiService, private sharedService: SharedService) {
  }

  ngOnInit(): void {
    this.sharedService.getCode().subscribe({
      next: (code: string) => {
        this.apiService.getFactContent(code).subscribe({
          next: (content: string) => {
            this.code = content;
          }
        });
      }
    });
  }

}
