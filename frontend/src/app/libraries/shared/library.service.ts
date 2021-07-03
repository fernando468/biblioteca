import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { getToken } from 'src/app/shared/utils/token';
import { environment } from 'src/environments/environment';
import { Library } from './library.model';

@Injectable({
  providedIn: 'root'
})
export class LibraryService {
  baseUrl = `${environment.apiUrl}`;

  constructor(private http: HttpClient) { }

  create(library: Library): Observable<Library> {
    return this.http.post<Library>(`${this.baseUrl}/libraries`, library, {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    });
  }

  addBook(bookId: string, libraryId: string): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/books/${bookId}/library/${libraryId}`, null, {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    });
  }

  getAll(page: number, size: number): Observable<Library[]> {
    return this.http.get<Library[]>(`${this.baseUrl}/libraries?page=${page}&size=${size}`);
  }

}
