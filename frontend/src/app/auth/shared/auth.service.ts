import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Auth } from './auth.model';
import { Token } from './token.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  baseUrl = `${environment.apiUrl}/auth`;
  constructor(private http: HttpClient) { }

  signIn(auth: Auth): Observable<Token> {
    return this.http.post<Token>(`${this.baseUrl}/signin`, auth);
  }
}
