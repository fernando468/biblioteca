import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LanguageFormDialogComponent } from '../language-form-dialog/language-form-dialog.component';
import { Language } from '../shared/language.model';
import { LanguageService } from '../shared/language.service';

@Component({
  selector: 'app-language',
  templateUrl: './language.component.html',
  styleUrls: ['./language.component.css']
})
export class LanguageComponent implements OnInit {
  languages: Language[] = [];
  dialogOpened = false;
  language: Language;

  constructor(private languageService: LanguageService, public dialog: MatDialog) {
    this.language = {
      name: ''
    };
  }

  ngOnInit(): void {
    this.listLanguages();
  }

  listLanguages(): void {
    this.languageService.getAll().subscribe(response => {
      this.languages = response;
    });
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(LanguageFormDialogComponent);
    dialogRef.afterClosed().subscribe(() => {
      this.listLanguages();
    });
  }

}
