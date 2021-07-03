import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { BookResponse } from '../shared/book.model';
import { BookService } from '../shared/book.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  books: BookResponse[] = [];
  apiUrlImg = environment.apiUrlImg;
  page = 0;
  size = 5;
  pageable = { totalElements: 0 };
  pageEvent?: PageEvent;

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    this.bookService.getAll(this.size, this.page).subscribe((books: any) => {
      this.books = books.content;
      this.pageable.totalElements = books.totalElements;
    });
  }

  handlePage(event: any): void {
    this.page = event?.pageIndex;
    this.bookService.getAll(this.size, this.page).subscribe((books: any) => {
      this.books = books.content;
      this.pageable.totalElements = books.totalElements;
    });
  }

}
