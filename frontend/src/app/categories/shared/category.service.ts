import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { getToken } from 'src/app/shared/utils/token';
import { environment } from 'src/environments/environment';
import { Category } from './category.model';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  baseUrl = `${environment.apiUrl}/categories`;
  constructor(private http: HttpClient) { }

  create(category: Category): Observable<Category> {
    return this.http.post<Category>(`${this.baseUrl}`, category, {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    });
  }

  getAll(): Observable<Category[]> {
    return this.http.get<Category[]>(`${this.baseUrl}`, {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    });
  }
}
