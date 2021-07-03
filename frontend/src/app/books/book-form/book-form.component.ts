import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/categories/shared/category.service';
import { LanguageService } from 'src/app/languages/shared/language.service';
import { SnackbarService } from 'src/app/shared/templates/snackbar/snackbar.service';
import { Author, BookForm, BookResponse, Category, Language } from '../shared/book.model';
import { BookService } from '../shared/book.service';

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css']
})
export class BookFormComponent implements OnInit {
  categories: Category[] = [];
  languages: Language[] = [];

  authors: Author[] = [];
  unmodifiableListOfAuthor: Author[] = [];
  allAuthorsSelected: Author[] = [];
  authorSelected: Author;

  book: BookForm;
  imgSelected: any;
  imgURL: any;

  constructor(
    private bookService: BookService,
    private categoryService: CategoryService,
    private languageService: LanguageService,
    private snackBar: SnackbarService,
    private router: Router
  ) {
    this.authorSelected = {
      name: '',
      id: ''
    };
    this.book = {
      authors: [],
      edition: '',
      file: {
        fileName: '',
        originalFileName: '',
        url: ''
      },
      genreId: '',
      languageId: '',
      isbn: '',
      publishingCompany: '',
      libraries: [],
      synopsis: '',
      title: '',
      totalPages: 0,
      yearOfPublication: ''
    };
  }

  ngOnInit(): void {
    this.categoryService.getAll().subscribe(response => {
      this.categories = response;
    });
    this.languageService.getAll().subscribe(response => {
      this.languages = response;
    });
    this.bookService.getAllAuthors().subscribe(response => {
      this.authors = response;
      this.unmodifiableListOfAuthor = response;
    });
  }

  addAuthor(event: any): void {
    if (this.authorSelected.name && this.authorSelected.id) {
      this.allAuthorsSelected.push(this.authorSelected);
    }
    if (this.authorSelected.name && !this.authorSelected.id) {
      this.allAuthorsSelected.push({ name: event.model });
    }
    this.authorSelected = { id: '', name: '' };
  }

  onSubmit(): void {
    this.book.authors = this.allAuthorsSelected;
    this.bookService.create(this.book, this.imgSelected).subscribe(response => {
      this.snackBar.showMessage('Livro cadastrado com sucesso!', false);
      this.router.navigate([`/livro/lista`]);
    }, () => this.snackBar.showMessage('Não foi possível cadastrar o livro!', true));
  }

  createPreviewImage(event: any): void {
    const reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = (e) => {
      this.imgSelected = event.target.files[0];
      this.imgURL = reader.result;
    };
  }

  removeAuthor(authorRemoved: Author): void {
    const index = this.allAuthorsSelected.indexOf(authorRemoved);
    this.allAuthorsSelected.splice(index, 1);
    if (authorRemoved.id) {
      const [authorFiltered] = this.unmodifiableListOfAuthor.filter(author => author.id == authorRemoved.id);
      this.authors.push(authorFiltered);
    }
  }

  onSelectionAuthorChanged(event: any): void {
    this.authorSelected = event;
    this.authors = this.authors.filter(author => author !== this.authorSelected);
  }
}
