import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { getToken } from 'src/app/shared/utils/token';
import { environment } from 'src/environments/environment';
import { Author, BookForm, BookResponse } from './book.model';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  baseUrl = `${environment.apiUrl}`;
  constructor(private http: HttpClient) { }

  create(book: BookForm, imgSelected: any): Observable<BookResponse> {
    const blob = new Blob([JSON.stringify(book)], {
      type: 'application/json'
    });
    const formData = new FormData();
    formData.append('file', imgSelected);
    formData.append('book', blob);
    return this.http.post<BookResponse>(`${this.baseUrl}/books`, formData, {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    });
  }

  getAll(size: number, page: number): Observable<BookResponse[]> {
    return this.http.get<BookResponse[]>(`${this.baseUrl}/books?size=${size}&page=${page}`);
  }

  getById(id: string): Observable<BookResponse> {
    return this.http.get<BookResponse>(`${this.baseUrl}/books/${id}`);
  }

  getAllAuthors(): Observable<Author[]> {
    return this.http.get<Author[]>(`${this.baseUrl}/authors`);
  }


  getAllByTitle(title: string): Observable<BookResponse[]> {
    return this.http.get<BookResponse[]>(`${this.baseUrl}/books/search?title=${title}`);
  }

}
