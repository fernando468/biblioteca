import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SnackbarService } from 'src/app/shared/templates/snackbar/snackbar.service';
import { LanguageComponent } from '../language/language.component';
import { Language } from '../shared/language.model';
import { LanguageService } from '../shared/language.service';

@Component({
  selector: 'app-language-form-dialog',
  templateUrl: './language-form-dialog.component.html',
  styleUrls: ['./language-form-dialog.component.css']
})
export class LanguageFormDialogComponent implements OnInit {
  language: Language = { name: '' };
  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef: MatDialogRef<LanguageComponent>,
    private languageService: LanguageService,
    private snackBar: SnackbarService
  ) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    if (this.language.name !== '') {
      this.languageService.create(this.language).subscribe(() => {
        this.snackBar.showMessage('Idioma cadastrado com sucesso!', false);
        this.language = { name: '' };
        this.onNoClick();
      }, () => this.snackBar.showMessage('Erro ao cadastrar idioma!', true));
    }
  }

  onNoClick(event?: any): void {
    event?.preventDefault();
    this.dialogRef.close();
  }
}
