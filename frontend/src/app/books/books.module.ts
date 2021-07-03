import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BookListComponent } from './book-list/book-list.component';
import { TemplatesModule } from '../shared/templates/templates.module';
import { MatButtonModule } from '@angular/material/button';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { RouterModule } from '@angular/router';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatCardModule } from '@angular/material/card';
import { BookFormComponent } from './book-form/book-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { BrowserModule } from '@angular/platform-browser';
import { MatSelectModule } from '@angular/material/select';

@NgModule({
  declarations: [
    BookListComponent,
    BookDetailComponent,
    BookFormComponent
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
    ReactiveFormsModule,
    MatListModule,
    MatIconModule,
    MatSelectModule
  ],
  exports: [BookListComponent, BookDetailComponent]
})
export class BooksModule { }
