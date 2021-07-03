import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { getToken } from 'src/app/shared/utils/token';
import { environment } from 'src/environments/environment';
import { Loan } from './loan.model';

@Injectable({
  providedIn: 'root'
})
export class LoanService {
  baseUrl = `${environment.apiUrl}/loans`;
  constructor(private http: HttpClient) { }

  getAllLoansByUserId(cpf: string, status: string): Observable<Loan[]> {
    return this.http.get<Loan[]>(`${this.baseUrl}/customer/cpf/${cpf}?status=${status}`, {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    });
  }

  getStatusList(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/status-list`, {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    });
  }

  changeStatus(id: string, status: string): Observable<Loan[]> {
    return this.http.put<Loan[]>(`${this.baseUrl}/change-status/${id}/status/${status}`, {}, {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    });
  }
}
