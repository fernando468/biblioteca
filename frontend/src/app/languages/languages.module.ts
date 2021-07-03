import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginatorModule } from '@angular/material/paginator';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { TemplatesModule } from '../shared/templates/templates.module';
import { LanguageComponent } from './language/language.component';
import { LanguageFormDialogComponent } from './language-form-dialog/language-form-dialog.component';

@NgModule({
  declarations: [
    LanguageComponent,
    LanguageFormDialogComponent,
  ],
  imports: [
    CommonModule,
    TemplatesModule,
    MatButtonModule,
    RouterModule,
    MatPaginatorModule,
    MatCardModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatAutocompleteModule,
    MatIconModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
  ]
})
export class LanguagesModule { }
