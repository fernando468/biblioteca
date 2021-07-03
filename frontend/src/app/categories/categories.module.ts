import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatRippleModule } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginatorModule } from '@angular/material/paginator';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { TemplatesModule } from '../shared/templates/templates.module';
import { CategoryComponent } from './category/category.component';
import { CategoryFormDialogComponent } from './category-form-dialog/category-form-dialog.component';
import { MatDialogModule } from '@angular/material/dialog';

@NgModule({
  declarations: [
    CategoryComponent,
    CategoryFormDialogComponent,
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
    MatDialogModule
  ]
})
export class CategoriesModule { }
