import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { BookResponse } from 'src/app/books/shared/book.model';
import { BookService } from 'src/app/books/shared/book.service';
import { SnackbarService } from 'src/app/shared/templates/snackbar/snackbar.service';
import { Library } from '../shared/library.model';
import { LibraryService } from '../shared/library.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {
  book = {
    title: '',
    id: ''
  };
  librarySelected = '';
  bookSelected = '';
  libraries: Library[] = [];
  books: BookResponse[] = [];

  constructor(
    private libraryService: LibraryService,
    private bookService: BookService,
    private snackBar: SnackbarService,
    private router: Router,
  ) {
  }

  ngOnInit(): void {
    this.libraryService.getAll(0, 30).subscribe((response: any) => {
      this.libraries = response.content;
    });
  }

  onSubmit(): void {
    this.libraryService.addBook(this.book.id, this.librarySelected).subscribe(() => {
      this.snackBar.showMessage('Livro adicionado na biblioteca com sucesso!', false);
      this.router.navigate([`/livro/lista/${this.book.id}`]);
    }, () => {
      this.snackBar.showMessage('Erro ao adicionar o livro!', true);
    });
  }

  onChange(event: any): void {
    if (event !== '' && event.length > 3) {
      this.bookService.getAllByTitle(event).subscribe(response => {
        this.books = response;
      });
    }
  }

  onSelectionChanged(event: any): void {
    this.book = event;
  }

}
