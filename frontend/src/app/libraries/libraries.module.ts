import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSelectModule } from '@angular/material/select';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { TemplatesModule } from '../shared/templates/templates.module';
import { AddBookComponent } from './add-book/add-book.component';
import { LibraryFormComponent } from './library-form/library-form.component';
import { LibraryListComponent } from './library-list/library-list.component';

@NgModule({
  declarations: [
    LibraryListComponent,
    LibraryFormComponent,
    AddBookComponent
  ],
  imports: [
    CommonModule,
    TemplatesModule,
    MatButtonModule,
    HttpClientModule,
    MatCardModule,
    MatPaginatorModule,
    BrowserAnimationsModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    RouterModule,
    MatSelectModule,
    MatAutocompleteModule
  ]
})
export class LibrariesModule { }
