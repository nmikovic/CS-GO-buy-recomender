import {Component, OnInit} from '@angular/core';
import {Rules} from '../../model/Rules';
import {ApiService} from '../../services/api.service';
import {SnackbarService} from '../../services/snackbar.service';

@Component({
  selector: 'app-text-editor',
  templateUrl: './text-editor.component.html',
  styleUrls: ['./text-editor.component.css']
})
export class TextEditorComponent implements OnInit {
  rules: Rules = {rules: ''};

  constructor(private apiService: ApiService, private snackbarService: SnackbarService) {
  }

  ngOnInit(): void {
  }

  checkIfTab(event) {
    if (event.key === 'Tab') {
      event.preventDefault();
      const start = event.target.selectionStart;
      const end = event.target.selectionEnd;
      event.target.value = event.target.value.substring(0, start) + '\t' + event.target.value.substring(end);
      event.target.selectionStart = event.target.selectionEnd = start + 1;
    }
  }

  submitRules() {
    this.apiService.createRules(this.rules).subscribe({
      next: (message: string) => {
        this.snackbarService.displayMessage(message);
      },
      error: (exception) => {
        this.snackbarService.displayMessage(exception.error);
      }
    });
  }

}
