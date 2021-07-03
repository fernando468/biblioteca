import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { getToken } from 'src/app/shared/utils/token';
import { environment } from 'src/environments/environment';
import { Language } from './language.model';

@Injectable({
  providedIn: 'root'
})
export class LanguageService {
  baseUrl = `${environment.apiUrl}/languages`;
  constructor(private http: HttpClient) { }

  create(language: Language): Observable<Language> {
    return this.http.post<Language>(`${this.baseUrl}`, language, {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    });
  }

  getAll(): Observable<Language[]> {
    return this.http.get<Language[]>(`${this.baseUrl}`);
  }

}
