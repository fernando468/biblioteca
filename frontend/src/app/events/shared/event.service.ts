import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { getToken } from 'src/app/shared/utils/token';
import { environment } from 'src/environments/environment';
import { Event, EventResponse } from './event.model';

@Injectable({
  providedIn: 'root'
})
export class EventService {
  baseUrl = `${environment.apiUrl}/events`;

  constructor(private http: HttpClient) { }

  create(event: Event): Observable<Event> {
    return this.http.post<Event>(`${this.baseUrl}`, event, {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    });
  }

  update(id: string, status: string): Observable<EventResponse> {
    return this.http.put<EventResponse>(`${this.baseUrl}/${id}/status/${status}`, {}, {
      headers: {
        Authorization: `Bearer ${getToken()}`
      }
    });
  }

  getAll(page: number, size: number): Observable<EventResponse[]> {
    return this.http.get<EventResponse[]>(`${this.baseUrl}?page=${page}&${size}`);
  }
}
