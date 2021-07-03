import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookResponse } from '../shared/book.model';
import { BookService } from '../shared/book.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {
  book!: BookResponse;
  apiUrlImg = environment.apiUrlImg;

  constructor(private bookService: BookService, private route: ActivatedRoute) {
    this.book = {
      authors: [],
      libraries: [],
      id: '',
      publishingCompany: '',
      edition: '',
      file: {
        fileName: '',
        originalFileName: '',
        url: ''
      },
      category: '',
      isbn: '',
      language: '',
      synopsis: '',
      title: '',
      totalPages: 0,
      yearOfPublication: ''
    };
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.bookService.getById(id).subscribe(book => {
        this.book = book;
      });
    }
  }

}
